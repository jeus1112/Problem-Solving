package BOJ;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_BOJ_S2_17086_아기상어2 {

	static int M,N;
	static int [][] map, sharks;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		map=new int[N][M];
		sharks=new int[N][M];
		ArrayList<int[]> sharkList=new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=scann.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1){
					sharkList.add(new int[]{i,j});
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//한점 i,j 에서 모든 상어사이의 초소거리
				int min=Integer.MAX_VALUE/100;
				for (int[] sh : sharkList) {
					if(map[i][j]==0){
						int man=distance(sh, new int[]{i,j});
						if(min>man){
							min=man;
							sharks[i][j]=min;
						}
					}
				}
			}
		}

		int max=-1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max=Math.max(max, sharks[i][j]);
			}
		}
		System.out.println(max);
	}
	static int distance(int[] s1, int [] p2){
		
		int d1=distance(s1[0],p2[0]);
		int d2=distance(s1[1],p2[1]);
		if(d1==d2){
			return d1;
		}else {
			int max=Math.max(d1, d2);
			return max;
		}
	}
	static int distance(int s1, int  p2){
		return Math.abs(s1-p2);
	}
}
