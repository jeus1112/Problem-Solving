package BOJ;

import java.util.Scanner;

public class Main_BOJ_B4_2588_곱셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int b1 = b%10;
		int b2 = (b/10)%10;
		int b3 = b/100;
		
		System.out.println(a*b1);
		System.out.println(a*b2);
		System.out.println(a*b3);
		System.out.println(a*b);
		
	}

}
