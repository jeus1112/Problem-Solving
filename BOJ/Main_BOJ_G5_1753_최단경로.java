package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.03.23
 * @algorithm Dijkstra
 * @version 1
 * 
 */
public class Main_BOJ_G5_1753_최단경로 {
	static class Edge{
		int v;
		int w;
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		List<Edge>[] adj = new ArrayList[V];	//객체 생성 안됬다 그냥 쓰면 널포인트 익셉션 뜸
		for (int i = 0; i < adj.length; i++) {
			adj[i]=new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u-1].add(new Edge(v-1, w));
		}
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		boolean[] check = new boolean[V];
		
		distance[K-1]=0;
		for (int i = 0; i < V-1; i++) {
			int min = Integer.MAX_VALUE;
			int w = -1;
			for (int j = 0; j < V; j++) {
				if (!check[j] && distance[j]<min) {
					min = distance[j];
					w = j;
				}
			}
			if (w==-1) {
				break;
			}
			check[w]=true;
			
			for (Edge next : adj[w]) {
				int v = next.v;
				if (!check[v] && distance[v] > distance[w]+next.w) {
					distance[v]= distance[w]+next.w;
				}
			}
		}
		
		for (int i = 0; i < V; i++) {
			if (distance[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
		
	}
}

/*

5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6



0
2
3
7
INF

*/