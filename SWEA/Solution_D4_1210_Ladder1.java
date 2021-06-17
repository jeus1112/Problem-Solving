package SWEA;

import java.util.Scanner;

public class Solution_D4_1210_Ladder1 {

	static int T = 10;
	static int N;
	static int[] dr = { 0, 0, -1 }; // 왼 오 위
	static int[] dc = { -1, 1, 0 }; // 왼 오 위

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();

			int[][] ladder = new int[100][100];

			int gor = 0; // 2의 위치
			int goc = 0; // 2의 위치

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
					if (ladder[i][j] == 2) {
						gor = i; // 행 99임
						goc = j; // 열
					}

				}
			}

			int d = 2; // 윗방향 시작

			while (gor != 0) {
				if (d != 1 && goc - 1 >= 0 && ladder[gor][goc - 1] > 0) {
					d = 0;
				}
				// 위로가다 오른쪽으로 이동 or 원래 오른쪽
				if (d != 0 && goc + 1 < 100 && ladder[gor][goc + 1] > 0) {
					d = 1;
				}
				int nr = gor + dr[d];
				int nc = goc + dc[d];
				if (nr >= 100 || nr < 0 || nc >= 100 || nc < 0 || ladder[nr][nc] == 0) {
					nr=nr-dr[d];	//원위치
					nc=nc-dr[d];
					d=2;
					nr = gor + dr[d];
					nc = goc + dc[d];
				}
				gor=nr;
				goc=nc;

			}
			System.out.println("#"+t+" "+goc);

		}

	}

}
