package BOJ;

import java.util.Scanner;

public class Main_BOJ_1110_더하기사이클_B1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int next = ((N%10)*10) + (((N/10)+(N%10))%10);
		int cnt = 1;
		while(next!=N) {
			next = ((next%10)*10) + (((next/10)+(next%10))%10);
			cnt++;
		}
		System.out.println(cnt);
		
	}

}