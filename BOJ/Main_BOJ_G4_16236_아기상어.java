package BOJ;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.03.24
 * 
 */
public class Main_BOJ_G4_16236_아기상어 {

	static class Fish{
		int x;
		int y;
		int w;
		public Fish(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	
	static int N;
	static int[][] map;
	static int sx, sy, distance;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int sharksize = 2;
	static boolean[][] v;
	static ArrayList<Fish> arr;
	static Queue<Fish> q;
	static int eat;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=sc.nextInt();
				if (map[i][j]==9) {
					sx = i;
					sy = j;
					map[i][j]=0;
				}
				if (map[i][j]!=0) {
					cnt++;
				}
			}
		}
		if (cnt==0) {
			System.out.println(0);
			return;
		}
		
		ans = 0;
		eat = 0;
		while(true) {
			arr = new ArrayList<>();
			v = new boolean[N][N];
			bfs(sx, sy, 0);
			
			if (arr.size()==0) {
				break;
			}
			Fish fish = arr.get(0);
			for (int i = arr.size()-1; i >=0; i--) {
				if (arr.get(i).w < fish.w) {
					fish = arr.get(i);
				}else if (arr.get(i).w == fish.w) {
					if (arr.get(i).x<fish.x) {
						fish = arr.get(i);
					}else if(arr.get(i).x == fish.x) {
						if (arr.get(i).y<fish.y) {
							fish = arr.get(i);
						}
					}
				}
				arr.remove(i);
			}
			eat++;
			if (eat==sharksize) {
				sharksize++;
				eat=0;
			}
			sx = fish.x;
			sy = fish.y;
			ans += fish.w;
			map[sx][sy]=0;
						
		}
		System.out.println(ans);
		
	}
	static void bfs(int x, int y, int w) {
		q = new LinkedList<>();
		q.offer(new Fish(x, y, w));
		v[x][y]=true;
		while(!q.isEmpty()) {
			Fish f = q.poll();
			int r = f.x;
			int c = f.y;
			int dist = f.w;
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (!check(nr,nc)) continue;			
				if (map[nr][nc]>sharksize) continue;				
				if (v[nr][nc]) continue;
				
				if (map[nr][nc]!=0 && map[nr][nc]<sharksize) {
					q.offer(new Fish(nr, nc, dist+1));
					v[nr][nc]=true;
					
					arr.add(new Fish(nr, nc, dist+1));
					
				}else if (map[nr][nc]==0 || map[nr][nc]==sharksize) {
					q.offer(new Fish(nr, nc, dist+1));
					v[nr][nc]=true;
				}
				
			}
		}
	}
	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
