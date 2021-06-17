package SWEA;
import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기 {

	static int T;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			String ss = sc.next();
			int count = 0;
			char a = '0';
			for (int i = 0; i < ss.length(); i++) {
				if (ss.charAt(i) != a) {
					count++;
					a = ss.charAt(i);
				}

			}

			System.out.println("#" + t + " " + count);
		}

	}

}
