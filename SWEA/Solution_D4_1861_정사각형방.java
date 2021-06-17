package SWEA;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.05
 * @algorithm 
 * @version 1
 * Solution_D4_1861_정사각형방
 */
public class Solution_D4_1861_정사각형방 {

	static int T;
	static int N;
	static int[][] room;
	static int[][] index;
	static int[] dr = { -1, +1, 0, 0 };
	static int[] dc = { 0, 0, -1, +1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			room = new int[N][N];
			index = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					room[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (index[i][j] == 0) {
						dfs(i, j);
					}
				}
			}

			result(t);
//			print(index);
		}

	}

	private static void result(int t2) {
		int num=Integer.MAX_VALUE;
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cnt<index[i][j]) {
					cnt=index[i][j];
					num=room[i][j];
				}else if (cnt==index[i][j]) {
					num=Math.min(num, room[i][j]);
				}
			}
		}
		System.out.println("#"+t2+" "+num+" "+cnt);
		
	}

//	private static void print(int[][] index2) {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(index2[i][j]+" ");
//
//			}
//			System.out.println();
//		}
//	}

	static void dfs(int r, int c) {
		index[r][c] = 1;		//중요~~~~
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr, nc)) continue;

			if (room[r][c] + 1 == room[nr][nc]) {

				if (index[nr][nc] == 0) { // 간적없냐
					dfs(nr, nc);
				}
				index[r][c]=Math.max(index[nr][nc]+1, index[r][c]);
			}

		}
		
	}

	static boolean check(int nr, int nc) {

		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
