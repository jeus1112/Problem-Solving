package SWEA;

import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.19
 * @algorithm 
 * @version 1
 * Solution_D4_3234_준환이의양팔저울
 */
public class Solution_D4_3234_준환이의양팔저울 {

	static int result;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			int[] nums = new int[N];
			
			for (int i = 0; i < N; i++) {
				nums[i]=sc.nextInt();
			}
			//로직
			boolean[] v = new boolean[N];
			result =0;
			
			chudfs(nums,v,0,0,0);
			
			
			//출력
			System.out.println("#"+t+" "+result);
		}		
	}

	static void chudfs(int[] arr, boolean[] v, int left, int right, int cnt) {
		
		if(right>left) return;	//가지치기
		
		if(cnt==arr.length) {
			result++;
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (v[i]) {
				continue;
			}
			v[i]=true;
			chudfs(arr, v, left+arr[i], right, cnt+1);
			chudfs(arr, v, left, right+arr[i], cnt+1);
			v[i]=false;
			
		}
	}
}
