package BOJ;


import java.io.*;
import java.util.Arrays;

/**
 * @author JAEWOO SHIM
 * @date  
 *	
 *	10 센티미터 = 100,000,000 나노미터
 *	1 센티미터 = 10,000,000 나노미터
 */
public class Main_BOJ_3649_로봇프로젝트_G4 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		while ((str=br.readLine())!= null) {
			int x = Integer.parseInt(str) * 10000000;
			int n = Integer.parseInt(br.readLine());
			int[] l = new int[n];
			for (int i = 0; i < n; i++) {
				l[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(l);
			int start = 0;
			int end = l.length-1;
			boolean flag = false;
			while (start < end) {
				int sum = l[start]+l[end];
				if (sum == x) {
					flag = true;
					break;
				} else if (sum < x) {
					start++;
				} else {	//sum>x
					end--;
				}
			}
			if (flag) {
				System.out.println("yes " + l[start] + " " + l[end]);
			}else{
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