package SWEA;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.15
 * @algorithm 
 * @version 4
 * Solution_D3_6808_규영이와인경이의카드게임4
 */
/*
 * Combination
 * 24008kb
 * 1299ms
 * 1340
*/
public class Solution_D3_6808_규영이와인경이의카드게임 {

	static int T;
	static int N = 9;
	static int[] cards;
	static int[] gyu;
	static int[] inn;
	static int[] num;
	static int win;
	static int lose;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			cards = new int[2 * N];
			gyu = new int[N];
			inn = new int[N];
			num = new int[N];
			for (int i = 0; i < N; i++) {
				gyu[i] = sc.nextInt();
				cards[gyu[i] - 1]++;
			}

			int cnt = 0;
			for (int i = 0; i < 2 * N; i++) {
				if (cards[i] == 0) {
					inn[cnt] = i + 1;
					cnt++;
				}
			}
			win = 0;
			lose = 0;
			System.arraycopy(inn, 0, num, 0, N);
			combiCard(0);
			System.out.println("#" + t + " " + win + " " + lose);

		}
	}

	private static void combiCard(int cnt) {
		if (cnt == N) {
			int gw = 0;
			int iw = 0;
			for (int i = 0; i < N; i++) {
				if (gyu[i] > num[i]) { // 규영 승
					gw += gyu[i] + num[i];
				} else if (gyu[i] < num[i]) { // 인영 승
					iw += gyu[i] + num[i];
				}
			}
			if (gw > iw) {
				win++;
			} else if (gw < iw) {
				lose++;
			}

			return;
		}
		for (int i = cnt; i < N; i++) {
			int temp = num[cnt];
			num[cnt] = num[i];
			num[i] = temp;
			combiCard(cnt + 1);
			temp = num[cnt];
			num[cnt] = num[i];
			num[i] = temp;
		}
	}

}
