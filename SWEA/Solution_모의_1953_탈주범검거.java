package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @author JAEWOO SHIM
 * @date  
 *		
 *	bfs를 이용
 *	depth 탐색은 v 배열을 이용
 *	1~7까지의 통로에 따라서 갈수 있는 곳과 없는 곳을 pathcheck을 통해 판별
 *
 */
public class Solution_모의_1953_탈주범검거 {
	
	static int T;
	static int N, M, R, C, L;
	static int[][] map;
	static int[][] v;
	static int[] dr = { -1,1,0,0};	//상하좌우
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			v = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<Integer> que = new LinkedList<Integer>();
			que.offer(R);	// i
			que.offer(C);	// j
			v[R][C]=1;
			int depth = 0;
			while(!que.isEmpty()){
				int r = que.poll();
				int c = que.poll();
				depth = v[r][c];
				if (depth==L) {
					break;
				}
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (!check(nr,nc)) {
						continue;
					}
					if (v[nr][nc]!=0) {
						continue;
					}
					if (map[nr][nc]==0) {
						continue;
					}
					if (!pathcheck(map[r][c], map[nr][nc], d)) {
						continue;
					}
					que.offer(nr); que.offer(nc);
					v[nr][nc]=depth+1;
				}
				
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (v[i][j]!=0) {
						cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
		
	}

	private static boolean pathcheck(int before, int after, int d) {

		if (d == 0) { // 상
			if (before == 3 || before == 5 || before ==6) {
				return false;
			}
			if (after == 3 || after == 4 || after == 7) {
				return false;
			}
		} else if (d == 1) { // 하
			if (before == 3 || before == 4 || before == 7) {
				return false;
			}
			if (after == 3 || after == 5 || after == 6) {
				return false;
			}
		} else if (d == 2) { // 좌
			if (before == 2 || before == 4 || before == 5) {
				return false;
			}
			if (after == 2 || after == 6 || after == 7) {
				return false;
			}
		} else if (d == 3) { // 우
			if (before == 2 || before == 6 || before == 7) {
				return false;
			}
			if (after == 2 || after == 4 || after == 5) {
				return false;
			}
		}

		return true;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}

/*
1
5 6 2 1 3
0 0 5 3 6 0
0 0 2 0 2 0
3 3 1 3 7 0
0 0 0 0 0 0
0 0 0 0 0 0


1
5 6 2 2 6
3 0 0 0 0 3
2 0 0 0 0 6
1 3 1 1 3 1
2 0 2 0 0 2
0 0 4 3 1 1
10 10 4 3 9

15

1
10 10 4 3 9
0 0 0 0 0 0 0 0 0 0
0 0 0 7 5 0 5 0 0 0
0 0 3 2 2 6 0 0 0 0
0 4 7 2 2 2 7 0 0 4
0 3 0 1 1 2 2 0 0 5
0 5 6 1 1 1 1 6 2 5
7 4 1 2 0 0 4 6 0 0
5 3 1 7 0 2 2 6 5 7
7 3 2 1 1 7 1 0 2 7
3 4 0 0 4 0 5 1 0 1


*/