package BOJ;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.10
 * @algorithm 
 * @version 1
 * Main_BOJ_G4_17406_배열돌리기4
 */
public class Main_BOJ_17406_배열돌리기4_G4 {

	static int N, M, K;
	static int[][] A;
	static int[][] KA;

	static int[] num;
	static boolean[] v;
	static int[][] Acopy;
	static int ans;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		A = new int[N][M];
		Acopy = new int[N][M];

		K = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		KA = new int[K][3];
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < 3; j++) {
				KA[i][j] = sc.nextInt();
			}
		}
		
		num = new int[K];
		v = new boolean[K];
		ans = Integer.MAX_VALUE;
		nPr(0);

		System.out.println(ans);

	}

	private static void nPr(int cnt) {
		if (cnt == K) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					Acopy[i][j] = A[i][j];
				}
			}
			for (int i = 0; i < K; i++) {
				rotate(num[i]);
			}
			ans = Math.min(ans, calculate());
			return;
		}
		for (int i = 0; i < K; i++) {
			if (v[i]) {
				continue;
			}
			v[i] = true;
			num[cnt] = i;
			nPr(cnt + 1);
			v[i] = false;
		}
	}

	private static void rotate(int i) {
		int[] ka = KA[i];
		int sr = ka[0] - ka[2] - 1;
		int sc = ka[1] - ka[2] - 1;
		int er = ka[0] + ka[2] - 1;
		int ec = ka[1] + ka[2] - 1;

		int rotcnt = Math.min((er - sr), (ec - sc)) / 2;

		for (int b = 0; b < rotcnt; b++) {
			int r = b + sr;
			int c = b + sc;
			int d = 0;

			int temp = Acopy[r][c];
			while (d < 4) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= b + sr && nr < er + 1 - b && nc >= b + sc && nc < ec + 1 - b) {
					Acopy[r][c] = Acopy[nr][nc];
					r = nr;
					c = nc;
				} else {
					d++;
				}
			}
			Acopy[b + sr][b + sc + 1] = temp;
		}

	}

	private static int calculate() {
		int minC = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += Acopy[i][j];
			}
			minC = Math.min(minC, sum);
		}
		return minC;
	}

}


























