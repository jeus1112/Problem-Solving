package PM;

import java.util.Scanner;

public class Solution_위클리챌린지_1주차_210803 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int price = sc.nextInt();
		int money = sc.nextInt();
		int count = sc.nextInt();

		System.out.println(sol(price, money, count));

	}

	public static long sol(int price, int money, int count) {
//		long answer = -1;
//		long total = price * (long)(count * (1 + count) / 2);
//		if (total > money) {
//			answer = total - money;
//		} else {
//			answer = 0;
//		}
//		return answer;
		return Math.max(price*(long)(count*(1+count)/2) - money, 0);
	}

}
