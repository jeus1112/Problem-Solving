package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D6_1267_작업순서 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int t = 1; t <= 10; t++) {

			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			int[][] node = new int[V + 1][V + 1];
			boolean[] v = new boolean[V + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				node[from][to] = 1;
			}
			Stack<Integer> stack = new Stack<>();

			while (true) {
				if (stack.size()==V) {
					break;
				}
				for (int i = 1; i <= V; i++) {
					boolean flag = true;
					if (v[i]) {
						continue;
					}
					for (int j = 1; j <= V; j++) {
						if (node[i][j] == 1) {
							flag = false;
							break;
						}
					}
					if (flag && !v[i]) {
						v[i] = true;
						for (int j = 1; j <= V; j++) {
							node[j][i]=0;
						}
						stack.add(i);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb.append(stack.pop()+" ");
			}
			System.out.println("#"+t+" "+sb.toString());
		}
	}
}
