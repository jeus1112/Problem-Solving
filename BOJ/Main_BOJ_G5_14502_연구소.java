package BOJ;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_G5_14502_연구소 {

	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int cnt;
	static int[][] copy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		copy = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		cnt=0;
		dfs(0,0,3);
		System.out.println(cnt);
		
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void dfs(int r, int c, int wall) {
		if (wall==0) {
			copy();
			spread();
			int tmp = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copy[i][j]==0) {
						tmp++;
					}
				}
			}
//			if (tmp==32) {
//				
//				System.out.println("===============");
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < M; j++) {
//						System.out.print(copy[i][j]+" ");
//					}
//					System.out.println();
//				}
//			}
			cnt = Math.max(cnt, tmp);
			return;
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if (map[i][j]==0) {
//					map[i][j]=1;
//					dfs(i,j,wall-1);
//					map[i][j]=0;
//				}
//			}
//		}
		
		// 조합으로 풀면 더 빠름
		for (int i = r; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]==0) {
					map[i][j]=1;
					dfs(i,j+1,wall-1);
					map[i][j]=0;
				}
			}
		}
//		for (int d = 0; d < 4; d++) {
//			int nr = r+dr[d];
//			int nc = c + dc[d];
//			
//			if (!check(nr,nc)) {
//				continue;
//			}
//			if (map[nr][nc]==2 || map[nr][nc]==1) {
//				continue;
//			}
////			if (v[nr][nc]) {
////				continue;
////			}
////			v[nr][nc]=true;
//			map[nr][nc]=1;
//			dfs(nr,nc,wall-1);
//			map[nr][nc]=0;
//		}
		
	}
	
	private static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j]=map[i][j];
			}
		}
	}
	private static void spread() {
		Queue<int[]> que = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j]==2) {
					que.offer(new int[] {i, j});
				}
			}
		}
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			int r = curr[0];
			int c = curr[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr,nc)) {
					continue;
				}
				if (copy[nr][nc]==0) {
					copy[nr][nc]=2;
					que.offer(new int[] {nr,nc});
				}
			}
			
		}
	}
	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
