package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_G5_3055_탈출 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		int[][] v = new int[N][M];
		Queue<Integer> que = new LinkedList<Integer>();
		int sr=0, sc=0;
		int er=0, ec=0;
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]=='S') {
					sr = i;
					sc = j;
				}
				if (map[i][j]=='D') {
					er=i;
					ec=j;
				}
				if (map[i][j]=='*') {
					que.offer(i); que.offer(j); que.offer(1);
					v[i][j]=0;
				}
			}
		}
		que.offer(sr); que.offer(sc); que.offer(0);
		v[sr][sc]=0;
		while(!que.isEmpty()) {
			int curR = que.poll();
			int curC = que.poll();
			int curS = que.poll(); // 0:고돌 1:물
			
			if (curR==er && curC==ec && curS==0) {
				System.out.println(v[er][ec]);
				System.exit(0);
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				
				if( !( nr>=0&& nr<N && nc>=0 && nc<M ) ) continue;
				if(v[nr][nc]!=0)continue;
				
				if ((curS==0 && map[nr][nc]=='.') || (curS==0 && map[nr][nc]=='D') ) { //고돌
					que.offer(nr); que.offer(nc); que.offer(0);
					v[nr][nc]=v[curR][curC]+1;
				}
				if (curS==1 && map[nr][nc]=='.') {
					que.offer(nr); que.offer(nc); que.offer(1);
					v[nr][nc]=v[curR][curC]+1;
				}
				
				
			}
		}
		
		System.out.println("KAKTUS");
		
		
	}
}
