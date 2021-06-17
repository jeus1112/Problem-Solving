package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author JAEWOO SHIM
 * @date  
 *	
 *	10 센티미터 = 100,000,000 나노미터
 *	1 센티미터 = 10,000,000 나노미터
 */
public class Main_BOJ_G4_3649_로봇프로젝트2 {

	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		while(true) {
			String str = br.readLine();
			if (str==null) {
				break;
			}
			int x = Integer.parseInt(str);
			int n = Integer.parseInt(br.readLine());
			int lego[] = new int[n];
			for (int i = 0; i < n; i++) {
				lego[i]=Integer.parseInt(br.readLine());
			}
			// 입력 완료
			boolean flag = false;
			int a = 0;
			int b = 0;
			int check = 0;
			Arrays.sort(lego);
			for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					if ((lego[i]+lego[j])%10000000==0 && (lego[i]+lego[j])/10000000 == x) {
						flag = true;
						if (check==0) {
							a = lego[i];
							b = lego[j];
							check = Math.abs(a-b);
						}else {
							if (check<Math.abs(a-b)) {
								a = lego[i];
								b = lego[j];
								check = Math.abs(a-b);
							}
						}
					}
				}
			}
			
			// 출력
			if (flag) {
				System.out.println("yes "+a+" "+b);
			}else {
				System.out.println("danger");
			}
		}
		
	}
}


/*

1
3
4000000
5000000
7000000

*/