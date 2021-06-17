package BOJ;

import java.util.Scanner;

public class Main_BOJ_B2_1592_영식이와친구들 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		int[] map = new int[N];

		int cnt = 0;

		int i = 0;
		map[0] = 1;
		while (true) {

			if (map[i] % 2 == 0) {
				i = (i - L + N) % N;
				map[i]++;
				cnt++;
			} else {
				i = (i + L) % N;
				map[i]++;
				cnt++;
			}
			if (map[i] == M) {
				break;
			}

		}
		System.out.println(cnt);
	}

}
