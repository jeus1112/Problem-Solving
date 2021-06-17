package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.03.25
 * @algorithm Floyd_Warshall
 * @version 1
 * Solution_D6_1263_사람네트워크2
 */
public class Solution_D6_1263_사람네트워크2 {

	static int T;
	static int N;
	static int INF = 9999999;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if (map[i][j]==0) {
						map[i][j]=INF;
					}
				}
			}
			
			// 경 출 목
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i==k) {
						continue;
					}
					for (int j = 0; j < N; j++) {
						if (i==j || j==k) {
							continue;
						}
						if(map[i][j] > map[i][k]+map[k][j]) {
							map[i][j] = map[i][k]+map[k][j];
						}
					}
				}
			}
			int[] dist = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j]==INF) {
						map[i][j]=0;
					}
					dist[i]+=map[i][j];
				}
			}
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				ans = Math.min(ans, dist[i]);
			}
			System.out.println("#"+t+" "+ans);
			
		}
	}
}

/*
1
3 0 1 0 1 0 1 0 1 0

*/