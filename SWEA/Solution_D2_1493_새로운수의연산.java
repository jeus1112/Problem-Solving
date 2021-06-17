package SWEA;
import java.util.Scanner;

public class Solution_D2_1493_새로운수의연산 {

	// 좌표
	static int[] getCoor(int target) {
		int cnt = 1;
		for (int i = 1;; i++) {
			for (int x = 1, y = i; x <= i; x++, y--) {
				if (target == cnt) {
					return new int[] { x, y };
				}
				cnt++;
			}
		}
	}

	static int getValue(int nx, int ny) {
		int cnt = 1;
		for (int i = 1;; i++) {
			for (int x = 1, y = i; x <= i; x++, y--) {
				if (nx == x && ny == y) {
					return cnt;
				}
				cnt++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			int[] p = getCoor(sc.nextInt());
			int[] q = getCoor(sc.nextInt());

			int x = p[0] + q[0];
			int y = p[1] + q[1];

			int ans = getValue(x, y);

			System.out.println("#" + t + " " + ans);
		}
	}
}
