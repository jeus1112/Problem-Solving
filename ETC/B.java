package ETC;

import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {

			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				System.exit(0);
			}

			int[][] node = new int[N][N];
			for (int i = 0; i < N; i++) {
				String ss = br.readLine();
				if (ss.equals("")) {
					continue;
				} else {
					st = new StringTokenizer(ss);
					while (st.hasMoreTokens()) {
						int b = Integer.parseInt(st.nextToken());
						node[i][b] = 1;
					}
				}
			}

			int[] v = new int[N];
			Queue<Integer> que = new LinkedList<>();
			que.offer(0);
			v[0] = 0;
			while (!que.isEmpty()) {
				int curr = que.poll();
				for (int i = 0; i < N; i++) {
					if (v[i] >= v[curr] + 1) {
						continue;
					}
					if (node[curr][i] == 1) {
						que.offer(i);
						v[i] = Math.max(v[i], v[curr] + 1);
					}
				}
			}

			int ans = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				ans = Math.max(ans, v[i]);
			}
			System.out.println(ans);
		}
	}
}
