package SWEA;

import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.18
 * @algorithm Permuattion
 * @version 1
 * Solution_D5_1247_최적경로
 */
public class Solution_D5_1247_최적경로 {

	static int T;
	static int N;
	static int[][] customer;
	static boolean[] v;
	static int[][] num;
	static int min;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			customer = new int[N + 2][2];
			num = new int[N][2];
			v = new boolean[N];
			customer[0][0]=sc.nextInt();
			customer[0][1]=sc.nextInt();
			customer[N+1][0]=sc.nextInt();
			customer[N+1][1]=sc.nextInt();

			for (int i = 1; i <= N; i++) {
				customer[i][0] = sc.nextInt();
				customer[i][1] = sc.nextInt();
			}
			min = Integer.MAX_VALUE;
			nPr(0, new boolean[N], customer[0][0], customer[0][1], 0);
			
			System.out.println("#"+t+" "+min);
		}

	}

	private static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}

	private static void nPr(int cnt, boolean[] v, int px, int py, int sum) {
		if (cnt==N) {
			sum+=dist(customer[N+1][0],customer[N+1][1],px, py);
			min = Math.min(min, sum);
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if (v[i]) {
				continue;
			}
			v[i]=true;
			nPr(cnt+1, v, customer[i+1][0],customer[i+1][1],
					sum+dist(customer[i+1][0],customer[i+1][1],px,py));
			v[i]=false;
		}
	}

}
