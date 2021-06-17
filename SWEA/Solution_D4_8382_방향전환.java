package SWEA;

import java.util.Scanner;

public class Solution_D4_8382_방향전환 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <=T; t++) {
			
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int ans = 0;
			
			int dx = Math.abs(x1-x2);
			int dy = Math.abs(y1-y2);
			int dp = Math.abs(dx+dy);
			int dm = Math.abs(dx-dy);
//			if (dp==dm) {
//				
//			}
//			int tt = dp - dm;
			ans = dp - dm +(2*dm)-(dm%2);
//			(dx+dy)-(dx-dy)+(2*(dx-dy))-((dx-dy)%2)
//			if (dx==0 || dy==0) {
//				if (dx==0 && dy%2==1) {
//					ans = dy*2 -1;
//				}else if (dx==0 && dy%2==0) {
//					ans = dy*2;
//				}else if (dy==0 && dx%2==1) {
//					ans = dx*2 -1;
//				}else if (dy==0 && dx%2==0) {
//					ans = dx*2;
//				}
//			}else {
//				
//				ans = dx+dy;
//			}
//			
			System.out.println("#"+t+" "+ans);
			
		}
	}
}
