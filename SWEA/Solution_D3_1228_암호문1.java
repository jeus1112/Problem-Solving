package SWEA;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.08
 * @algorithm 
 * @version 1
 * Solution_D3_1228_암호문1
 */
public class Solution_D3_1228_암호문1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			int N = sc.nextInt();
			ArrayList<Integer> num = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				num.add(sc.nextInt());
			}
			
			// ---------원본 입력 완료
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {

				String s = sc.next();

				int x = sc.nextInt();
				int y = sc.nextInt();
				for (int j = 0; j < y; j++) {

					num.add(x + j, sc.nextInt());
				}
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(num.get(i) + " ");
			}
			System.out.println();
		}

	}

}
