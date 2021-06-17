package JO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_JO_1733_오목 {
	public static int Answer, ansi, ansj;
	public static int N = 19;
	public static int[][] board;
	public static int[] di = { -1, 0, 1, 1 };
	public static int[] dj = { 1, 1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(str[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != 0) {
					search(i, j);
				}
			}
		}

		System.out.println(Answer);
		if (Answer != 0) {
			System.out.println(ansi + " " + ansj);
		}

		br.close();
	}

	public static void search(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int cnt = 0;
			int ii = i;
			int jj = j;
			for (int k = 0; k < 5; k++) {
				ii = ii + di[d];
				jj = jj + dj[d];
				if (ii < 0 || ii >= N || jj < 0 || jj >= N || board[ii][jj] != board[i][j])
					break;
				if (board[ii][jj] == board[i][j]) {
					cnt++;
				}
			}
			if (cnt == 4) {
				if (i - di[d] < 0 || i - di[d] >= N || j - dj[d] < 0 || j - dj[d] >= N
						|| board[i - di[d]][j - dj[d]] != board[i][j]) {
					Answer = board[i][j];
					ansi = i + 1;
					ansj = j + 1;
				}
			}
		}
	}
}
