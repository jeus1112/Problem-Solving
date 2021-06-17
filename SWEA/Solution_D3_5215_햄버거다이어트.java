package SWEA;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.08
 * @algorithm 
 * @version 1
 * Solution_D3_5215_햄버거다이어트
 */
public class Solution_D3_5215_햄버거다이어트 {

	static int T, N, L;
	static int[] num;
	static int[] cal;
	static int max;
	static int[] n;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			num = new int[N];
			cal = new int[L];
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
				
			max=Integer.MIN_VALUE/100;
			subset(0, 0,0);
			System.out.println("#"+t+" "+max);

		}
	}

	private static void subset(int cnt, int sum, int val) {
		
		if(cnt==N) {
			if(sum<=L) {
				max=Math.max(max, val);
			}
			return;
		}
		subset(cnt+1, sum+cal[cnt], val+num[cnt]);
		subset(cnt+1, sum, val);	
	}
	
}
