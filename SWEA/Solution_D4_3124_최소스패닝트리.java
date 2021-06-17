package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.03.23
 * 
 */
public class Solution_D4_3124_최소스패닝트리 {

	static class Edge implements Comparable<Edge> {

		int a;
		int b;
		int c;

		public Edge(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.c, e.c); // 어센딩
		}

	}

	static int T;
	static int V, E;
	static int[] p;
	static int[] r;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			PriorityQueue<Edge> pq = new PriorityQueue<>();

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				pq.offer(new Edge(a - 1, b - 1, c));
			}

			makeSet();
			long sum = 0L;

			while (!pq.isEmpty()) {
				Edge next = pq.poll();
				if (!isConnect(next.a, next.b)) {
					union(next.a, next.b);
					sum += next.c;
				}
			}

			System.out.println("#" + t + " " + sum);

		}
	}

	static void makeSet() {
		p = new int[V];

		for (int i = 0; i < V; i++) {
			p[i] = i;
		}
		r = new int[V];
		Arrays.fill(r, 1);
	}

	static int find(int x) {
		if (x == p[x]) {
			return p[x];
		}

		return p[x] = find(p[x]);
	}

	static boolean isConnect(int x, int y) {
		if (find(x) == find(y)) {
			return true;
		}

		return false;

	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px == py) {
			return;
		}

		if (r[px] >= r[py]) {
			r[px] += r[py];
			p[py] = px;
		} else {
			r[py] += r[px];
			p[px] = py;
		}

	}
}
