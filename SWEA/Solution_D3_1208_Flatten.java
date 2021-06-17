package SWEA;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1208_Flatten {
	
	static int T = 10;
	static int W = 100;
	static int[] map;
	static int dump;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= T; t++) {
			dump = sc.nextInt();
			map = new int[W];
			for (int i = 0; i < W; i++) {
				map[i] = sc.nextInt();
			}
			int diff = 0;

			for (int i = 0; i <= dump; i++) {
				int hmax = Integer.MIN_VALUE;
				int hmin = Integer.MAX_VALUE;

				Arrays.sort(map);
				hmax = map[W - 1];
				hmin = map[0];

				if (hmax - hmin <= 1) {
					break;
				}
				map[W - 1] = hmax - 1;
				map[0] = hmin + 1;

				diff = hmax - hmin;
			}

			System.out.println("#" + t + " " + diff);
		}
	}
}
