package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10157_자리배정_S5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[] dr= {-1,0,1,0};	//상우하좌
		int[] dc = {0,1,0,-1};
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		int[][] map = new int[R][C];
		
		if (K>R*C) {
			System.out.println("0");
			return;
		}
		// R,0이 시작지점
		int nr = R-1;
		int nc = 0;
		int num = 1;
		map[nr][nc]=1;
		int d = 0;
		while(true) {
			nr+=dr[d];
			nc+=dc[d];
			if (!(nr>=0 && nr<R && nc>=0 && nc<C)||map[nr][nc]!=0) {
				nr-=dr[d];
				nc-=dc[d];
				d=(d+1)%4;
				nr+=dr[d];
				nc+=dc[d];
			}
			if (map[nr][nc]==0) {
				num++;
				map[nr][nc]=num;
			}
			if (num==K) {
				int x = nc +1;
				int y = R - nr;
				System.out.println(x+" "+y);
				return;
			}
		}
		
	}

}