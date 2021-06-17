package SWEA;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.03.25
 * @algorithm LST
 * @version 1
 * Solution_D3_3307_최장증가부분수열
 */
public class Solution_D3_3307_최장증가부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] LIS = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i]=sc.nextInt();
			}
			
			int max = 0;
			Arrays.fill(LIS, 1);
			for (int i = 0; i < N; i++) {
//				LIS[i]=1;
				for (int j = 0; j < i; j++) {
					if (arr[j]<arr[i] && LIS[i]<LIS[j]+1) {
						LIS[i] = LIS[j]+1;
					}
				}
//				if (max < LIS[i]) {
//					max = LIS[i];
//				}
				max = Math.max(max, LIS[i]);
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
