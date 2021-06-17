package SWEA;

import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.18
 * @algorithm greedy
 * @version 1
 * Solution_D5_1265_달란트
 */
public class Solution_D5_1265_달란트 {
	
	static int T, N, P;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			N = sc.nextInt();
			P = sc.nextInt();
			
			System.out.println("#"+t+" "+dal(N,P));
			
		}
		
		
	}

	static long dal(int n, int p) {
		
		if(p==1) {
			return 1L*n;
		}else {
			return 1L*n/p*dal(n-(n/p), p-1);
		}
	}
}
