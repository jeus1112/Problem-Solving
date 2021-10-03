package BOJ;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.10
 * @algorithm 
 * @version 1
 * Main_BOJ_S4_16926_배열돌리기1
 */
public class Main_BOJ_16926_배열돌리기1_S4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];

		int R = sc.nextInt();

		// 오 상 좌 하
		int[] dr = { 0,1,0,-1 };
		int[] dc = { 1,0,-1,0 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//----------------입력 완료	
		int r=0;
		int c=0;
		int d=0;
		
		for (int rn = 0; rn < R; rn++) {	//R번 회전
			int count = 0;
			int cnt = Math.min(N, M)/2;		//내부까지 몇번?
			for (int i = 0; i < cnt; i++) {

				r = i;
				c = i;	
				
				int temp = arr[r][c];
				
				while (count < 4) {

					if (r + dr[d] >= i && r + dr[d] < N - i 
							&& c + dc[d] >= i && c + dc[d] < M - i) {
						
						arr[r][c] = arr[r + dr[d]][c + dc[d]];
						r = r + dr[d];
						c = c + dc[d];
					} else {
						d = (d + 1) % 4;
						count++;
					}
				}
				count = 0;
				arr[i + 1][i] = temp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
