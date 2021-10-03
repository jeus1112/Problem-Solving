package BOJ;

import java.util.Scanner;
/**
 * @author JAEWOO SHIM
 * @date  21.04.05
 * 
 *	중복 조합을 이용한다.
 *
 */
public class Main_BOJ_16922_로마숫자만들기_S3 {

	static int[] p = {1,5,10,50};
	static int r;
	static boolean[] v;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		v = new boolean[1001];
		num = new int[r];
		combi(0,0);
		int ans = 0;
		for (int i = 0; i < 1001; i++) {
			if (v[i]) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	private static void combi(int cnt, int start) {
		if (cnt==r) {
			int tot = 0;
			for (int i = 0; i < r; i++) {
				tot += num[i];
			}
			if (v[tot]) {
				return;
			}
			v[tot]=true;
			return;
		}
		for (int i = start; i < 4; i++) {
			
			num[cnt]=p[i];
			combi(cnt+1, i);
		}
	}

}
