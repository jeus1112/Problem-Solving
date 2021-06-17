package BOJ;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.16
 * @algorithm 
 * @version 1
 * Main_BOJ_S1_1074_Z
 */
public class Main_BOJ_S1_1074_Z {

	static int N, r, c, cnt;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		r = scann.nextInt();
		c = scann.nextInt();
		cnt = 0;
		// 로직
//      z(0, 0, 1<<N);
		z(0, 0, (int) Math.pow(2, N));
	}

	static void z(int rr, int cc, int width) {
		if (width == 1) {
			if (rr == r && cc == c) {
				System.out.println(cnt);
			}
			cnt++;
			return;
		}
		// 범위내면 다시 4등분 찾기
		if (r >= rr && r <= rr + width && c >= cc && c <= cc + width) {
			int w = width / 2;
			z(rr, cc, w); // 11
			z(rr, cc + w, w); // 1
			z(rr + w, cc, w); // 7
			z(rr + w, cc + w, w); // 5
		} else
			cnt += width * width; // 범위 밖이면 찾지 않고 넓이 만큼 회수 증가

	}

}
