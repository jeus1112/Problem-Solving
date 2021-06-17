package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1219_길찾기_adjlist {

	static int[][] map;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());		
			int T = Integer.parseInt(st.nextToken());	
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());		
			map = new int[100][100];
			
			
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y]=1;
			}
			ans = 0;
			dfs(0);
			
			System.out.println("#"+t+" "+ans);
			
		}
	}

	private static void dfs(int i) {
		
		if (i==99) {
			ans=1;
			return;
		}
		for (int j = 0; j < 100; j++) {
			if (map[i][j]==1) {
				dfs(j);
			}
		}
		
	}
}
