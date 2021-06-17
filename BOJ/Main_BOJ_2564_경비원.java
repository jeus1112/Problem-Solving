package BOJ;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.05
 * @algorithm 
 * @version 3
 * 
 */
public class Main_BOJ_2564_경비원 {
	
	// 오 아 왼 위
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	static int W, H, S;
	static int[][] map;
	static ArrayList<int[]> points=new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		W=sc.nextInt();
		H=sc.nextInt();
		S=sc.nextInt();
		map=new int[H+1][W+1];
		points.clear();
		for (int i = 0; i < S; i++) {
			int first=sc.nextInt();
			int second=sc.nextInt();
			// (f,s) -> (r,d, dir)
			int[] cur=direction(first, second);
			points.add(cur);
		}
		
		//경비원 위치
		int er = sc.nextInt();
		int ec= sc.nextInt();
		int[] ecur = direction(er, ec);
		
		//이제 구하자
		int cnt=0;
		for (int[] point : points) {
			//ecur 경비원  point 상점 -> 시계방향으로 거리를 구함
			int result = goClock(point, ecur);
			//반시계가 짧으면 전체길이-시계
			cnt += Math.min(result, 2*(H+W)-result);
		}
		System.out.println(cnt);
		
	}
	
	static int goClock(int[] point, int[] ecur) {
		int count =0;
		int r=point[0];
		int c=point[1];
		int er = ecur[0];
		int ec = ecur[1];
		int d = ecur[2];
		
		for (int i = 0; i <= 2*(H+W); i++) {
			if(r==er && c==ec) {
				return count;
			}
			int nr=er+dr[d];
			int nc=ec+dc[d];
			// 오 아 왼 위 로 이동중에 범위 밖으로 나가면 아 왼 위 오 로 바뀜 // 이게 없었네..
			if(!(nr>=0 && nr<=H && nc>=0 && nc<=W)) {		//밖으로 나감
				d=(d+1)%4;	//방향전환
			}
			er=er+dr[d];
			ec=ec+dc[d];
			count++;
		}
		return count;
	}

	// (f,s) -> (r,d, dir)
	static int[] direction(int first, int second) {
		
		int r=0;
		int c=0;
		int dir=0;
		if(first==1) {
			r=0;
			c=second;
			dir=0;	// 오른쪽으로 이동 해야함
		}else if(first==2) {
			r=H;
			c=second;
			dir=2;	// 왼쪽으로 이동 해야함
		}else if(first==3) {
			r=second;
			c=0;
			dir=3;	
		}else if(first==3) {
			r=second;
			c=W;
			dir=1;	
		}

		int[] loc = new int[] { r, c, dir };
		return loc;
	}
}
