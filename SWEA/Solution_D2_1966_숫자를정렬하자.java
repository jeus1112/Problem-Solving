package SWEA;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @date 21.03.28
 * @author B250
 *
 */
public class Solution_D2_1966_숫자를정렬하자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			int[] nums = new int[N];
			
			for (int i = 0; i < N; i++) {
				nums[i]=sc.nextInt();
			}
			Arrays.sort(nums);
			System.out.print("#"+t+" ");
			for (int i = 0; i < N; i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
		}
	}
}
