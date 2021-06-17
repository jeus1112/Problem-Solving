package BOJ;

import java.util.Scanner;

public class Main_BOJ_S5_2567_색종이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 색종이 수
		int[][] map = new int[101][101];

		for (int n = 1; n <= N; n++) { // N개의 색종이
			// 3 7 입력
			int c = sc.nextInt(); // 3
			int r = sc.nextInt(); // 7

			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					map[i][j] = 1;
				}
			}

		}
		// ====입력완료

		// 사방에서 시작하는데 0 -> 1로 바뀌면 둘레 +1 이거만 체크
		int ans = 0;
		// ->
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (j + 1 < 101 && map[i][j] == 0 && map[i][j + 1] == 1) {
					ans++;
				}
			}
		}
		// <-
		for (int i = 0; i < 101; i++) {
			for (int j = 100; j >= 0; j--) {
				if (j - 1 > 0 && map[i][j] == 0 && map[i][j - 1] == 1) {
					ans++;
				}
			}
		}
		// ^
		for (int j = 0; j < 101; j++) {
			for (int i = 100; i >= 0; i--) {
				if (i - 1 > 0 && map[i][j] == 0 && map[i - 1][j] == 1) {
					ans++;
				}
			}
		}
		// V
		for (int j = 0; j < 101; j++) {
			for (int i = 0; i < 101; i++) {
				if (i + 1 < 101 && map[i][j] == 0 && map[i + 1][j] == 1) {
					ans++;
				}
			}
		}

		// 출력
		System.out.println(ans);
	}

}
