package SWEA;
import java.util.Scanner;

public class Solution_D4_1219_길찾기 {

	static int ans;
	static int[] a1;
	static int[] a2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int T = sc.nextInt();
			
			int E = sc.nextInt();	// 길의 개수
			
			a1 = new int[100];
			a2 = new int[100];
			
			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				if (a1[from]==0) {
					a1[from]=to;
				}else {
					a2[from]=to;
				}
			}
			/*
			 * a1[x] 가 존재하면
			 * a1[a1[x]] 로 이동
			 * 
			 */
			ans = 0;
			dfs(0);
			System.out.println("#"+t+" "+ans);
		}
	}

	private static void dfs(int i) {
		
		if (a1[i]==99 || a2[i]==99) {
			ans=1;
		}
		if (a1[i]!=0) {
			dfs(a1[i]);
		}
		if (a2[i]!=0) {
			dfs(a2[i]);
		}
		
	}
}

