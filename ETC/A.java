package ETC;

import java.io.*;
import java.util.*;

public class A {

	static int[] p;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				System.exit(0);
			}
			makeset();
			boolean[] v = new boolean[N];
			for (int i = 0; i < N; i++) {
				String ss = br.readLine();
				if (ss.equals("")) {
					continue;
				} else {
					st = new StringTokenizer(ss);
					while (st.hasMoreTokens()) {
						int b = Integer.parseInt(st.nextToken());
						union(i, b);
						v[i] = v[b] = true;
					}
				}
			}
			int[] comp = new int[N];
			for (int i = 0; i < N; i++) {
				comp[p[i]]++;
			}
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (comp[i] != 0) {
					list.add(i);
				}
			}
			boolean[][] vv = new boolean[N][N];
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i) == list.get(j)) {
						continue;
					}
					if (isConn(list.get(i), list.get(j))) {
						if (!vv[i][j]) {
							vv[i][j] = vv[j][i] = true;
							list.set(j, list.get(i));
						}
					}
				}
			}
			ArrayList<Integer> anslist = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (!anslist.contains(list.get(i))) {
					anslist.add(list.get(i));
				}
			}
			System.out.println(anslist.size());

		}
	}

	static void makeset() {
		p = new int[N];

		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
	}

	static int find(int x) {
		if (x == p[x]) {
			return p[x];
		} else {
			return p[x] = find(p[x]);
		}
	}

	static boolean isConn(int x, int y) {
		if (find(x) == find(y)) {
			return true;
		} else
			return false;
	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (find(x) == find(y)) {
			return;
		}
		if (px < py) {
			p[py] = px;
		} else {
			p[px] = py;
		}
	}

}
