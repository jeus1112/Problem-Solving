package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1238_contact_2 {

	static int N, S;
	static int[][] graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			
			graph = new int[N+1][N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from][to]=1;
			}
			int max = bfs();
			System.out.println("#"+t+" "+max);
		}
	}
	static int bfs() {
		int ans =0;
		// bfs 준비
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		// 출발점~~
		visited[S]=true;
		q.offer(S);
		
		// 우리는 depth가 필요해요 --> 현재 queue가 가지고 있는 개수까지만 돌아라!!
		int size = 0, maxNum = 0;
		while(!q.isEmpty()) {
			size = q.size();
			maxNum =0;	// 각각의 depth에서의 최대 숫자를 찾아야 하니까 초기화 필요!!!
			// depth 단위로 동작하기
			while(size-- > 0) {
				// 1. 맨 앞에 요소 가져오기
				int head = q.poll();
				
				// 2. 사용하기.
				maxNum = Math.max(maxNum, head);
				
				// 3. 다음 자식 찾기
				for (int c = 1; c <=N; c++) {
					// 미방문이고 연결되어있는 녀석
					if (!visited[c] && graph[head][c]==1) {
						visited[c]=true;
						q.offer(c);
					}
				}
			}
		}
		
		return maxNum;
	}
}








