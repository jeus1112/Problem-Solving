package SWEA;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.10
 * @algorithm 
 * @version 1
 * Solution_D2_1954_달팽이숫자
 */
public class Solution_D2_1954_달팽이숫자 {

	static int T;
	static int N;
	static int[][] snail;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			snail = new int[N][N];

			// 로직

			int r = 0;
			int c = 0;
			int d = 0; // 오

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					snail[r][c] = i * N + j + 1;
					// nr = r+dr[d] nc = r+dc[d]
					if (!(r + dr[d] >= 0 && r + dr[d] < N && c + dc[d] >= 0 && c + dc[d] < N
							&& snail[r + dr[d]][c + dc[d]] == 0)) {
						d = (d + 1) % 4;
					}
					r += dr[d];
					c += dc[d];
				}
			}

			// 출력
			print(t);

		}
	}

	static void print(int t) {
		System.out.println("#"+t);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < snail.length; j++) {
				System.out.print(snail[i][j] + " ");
			}
			System.out.println();
		}

	}
}
