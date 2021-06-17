package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1227_미로2 {

	static int T = 10;
	static int[][] map;
	static boolean[][] v;
	static int sr, sc, er, ec;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			
			int tc = Integer.parseInt(br.readLine());
			
			map=new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				String s = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j]=s.charAt(j)-'0';
				}
			}
			//=== 입력 완료
			
			//로직
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (map[i][j]==2) {
						sr = i;
						sc = j;
					}else if (map[i][j]==3) {
						er = i;
						ec = j;
					}
				}
			}
			ans = 0;
			bfs();
			
			//출력
			System.out.println("#"+tc+" "+ans);
		}
	}
	static int[] dr= {0,1,0,-1};	//우하좌상
	static int[] dc= {1,0,-1,0};
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sr, sc});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if (curr[0]==er && curr[1]==ec) {
				ans=1;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = curr[0]+dr[d];
				int nc = curr[1]+dc[d];
				
				if (!check(nr,nc)) {
					continue;
				}
				if (map[nr][nc]==1) {
					continue;
				}
				map[nr][nc]=1;
				q.offer(new int[] {nr, nc});
				
			}
		}
		
	}
	
	private static boolean check(int nr, int nc) {
		return nr>=0 && nr <100 && nc>=0 && nc<100;
	}

}