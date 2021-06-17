package SWEA;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.05
 * @algorithm 
 * @version 1
 * Solution_D3_3499_퍼펙트셔플
 */
public class Solution_D3_3499_퍼펙트셔플 {

	static int T;
	static int N;
	static String[] deck1;
	static String[] deck2;
	static String[] shuffled;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			if (N%2==0) {
				deck1 = new String[N/2];
				deck2 = new String[N/2];
				for (int i = 0; i < N/2; i++) {
					deck1[i] = sc.next();
				}
				for (int i = 0; i < N/2; i++) {
					deck2[i] = sc.next();
				}
			}else {
				deck1 = new String[N/2+1];
				deck2 = new String[N/2];
				for (int i = 0; i <= N/2; i++) {
					deck1[i] = sc.next();
				}
				for (int i = 0; i < N/2; i++) {
					deck2[i] = sc.next();
				}
			}
			shuffled = new String[N];

			for (int i = 0; i < N; i++) {
				if (i%2==0) {
					shuffled[i]=deck1[i/2];
				}else {
					shuffled[i]=deck2[(i-1)/2];					
				}
			}			
			System.out.print("#" + t + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(shuffled[i] + " ");
			}
			System.out.println();

		}
	}
}
