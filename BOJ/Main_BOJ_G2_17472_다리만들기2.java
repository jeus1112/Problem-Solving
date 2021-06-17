package BOJ;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 크루스칼 이용해서
 * 노드는 각 섬이고
 * 엣지의 가중치는 섬에서 섬까지의 거리
 * 이렇게?
 * 
 */
public class Main_BOJ_G2_17472_다리만들기2 {

	static class Island implements Comparable<Island>{
		int x;
		int y;
		int dist;
		public Island(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Island o) {
			return Integer.compare(this.dist, o.dist);
		}
		@Override
		public String toString() {
			return x + "," + y + "," + dist;
		}
		
	}
	static int N, M;
	static int[][] map;
	static ArrayList<Island> island;
	static int[] p;
	static int[] r;
	static int ans;
	static int inum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
				if (map[i][j]==1) {
					map[i][j]=-1;
				}
			}
		}
		int cnt = 0;
		inum=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]==-1) {
					cnt++;
					dfs(i, j, cnt);	// 섬 번호 붙이기
				}
			}
		}
		inum=cnt;
		island = new ArrayList<>();
		bridge();
		Collections.sort(island);
		makeSet();
		ans = 0;
		for (int i = 0; i < island.size(); i++) {
			if (!isConnect(island.get(i).x-1, island.get(i).y-1)) {
				union(island.get(i).x-1, island.get(i).y-1);
				ans += island.get(i).dist;
			}
		}
		if (checkunion()) {
			System.out.println(ans);
			return;
		}else {
			System.out.println("-1");
		}
	}
	static boolean checkunion() {
		int cnt = 0;
		for (int i = 0; i < inum; i++) {
			if (p[i]==i) {
				cnt++;
			}
		}
		if (cnt==1) {
			return true;
		}
		return false;
	}
	static void makeSet() {
		p = new int[inum];
		r = new int[inum];
		for (int i = 0; i < inum; i++) {
			p[i]=i;
		}
		Arrays.fill(r, 1);
	}
	
	static int find(int x) {
		if (x==p[x]) {
			return p[x];
		}
		
		return p[x]=find(p[x]);
	}
	
	static boolean isConnect(int x, int y) {
		if (find(x)==find(y)) {
			return true;
		}
		
		return false;
		
	}
	static void union(int x, int y ) {
		int px = find(x);
		int py = find(y);
		
		if (px==py) {
			return;
		}
		
		if (r[px] >= r[py]) {
			r[px] += r[py];
			p[py] = px;
		}else {
			r[py]+=r[px];
			p[px]=py;
		}
		
	}
	
	private static void bridge() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]!=0) {
					int from = map[i][j];
					for (int d = 0; d < 4; d++) {
						int to = 0;
						int cnt = 0;
						int ni = i;
						int nj = j;
						while(true) {
							ni+=dr[d];
							nj+=dc[d];
							if (!check(ni,nj)) {
								break;
							}
							if (map[ni][nj]==from) {
								break;
							}
							if (map[ni][nj]!=0 && map[ni][nj]!=from) {
								if (cnt<2) {
									break;
								}
								to = map[ni][nj];
								island.add(new Island(from, to, cnt));
								break;
							}
							cnt++;
						}
					}
				}
			}
		}
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void dfs(int r, int c, int cnt) {
		
		map[r][c]=cnt;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr,nc)) {
				continue;
			}
			if (map[nr][nc]==-1) {
				dfs(nr,nc,cnt);
			}
		}
	}
	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
