package SWEA;
import java.util.Scanner;

public class Solution_D4_1486_장훈이의높은선반 {

	static int T; // TC 갯수
	static int N; // 점원의 수
	static int B; // 선반 높이
	static int S; // 점원 키의 합
	static int ans; // 답
	
	static int[] top;	// 점원의 키를 저장하는 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			
			N=sc.nextInt();
			B = sc.nextInt();
			
			top = new int[N];
			
			for (int i = 0; i < N; i++) {
				top[i]=sc.nextInt();
			}
			//====입력 완료
			
			ans = Integer.MAX_VALUE;
			subset(0,0);

			//출력
			System.out.println("#"+t+" "+ans);
			
		}
		
	}

	private static void subset(int cnt, int sum) {
		
		if (cnt==N) {
			if (sum>=B) {
				int ss = sum-B;
				ans = Math.min(ans, ss);
			}
			return;
		}
		
		subset(cnt+1, sum+top[cnt]);
		
		subset(cnt+1, sum);
		
	}
}
