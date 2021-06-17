package SWEA;
import java.util.Scanner;

public class Solution_D3_1220_Magnetic {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			int N = sc.nextInt();

			int[][] table = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					table[i][j] = sc.nextInt();

				}
			}
			int cnt = 0;
			
			for (int j = 0; j < N; j++) {
				int meet = 0;
				for (int i = 0; i < N; i++) {

					if (table[i][j] == 1) {
						meet=1;
					}
					if (table[i][j] == 0) {
						continue;
					}
					if (meet==1 && table[i][j] == 2) {
						meet=0;
						cnt++;
					}
					if (meet==0 && table[i][j] == 2) {
						continue;
					}

				}
			}

			System.out.println("#"+t+" "+cnt);

		}
	}
}
