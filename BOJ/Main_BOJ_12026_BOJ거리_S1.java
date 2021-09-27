package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_12026_BOJ거리_S1 {

	static class BOJ{
		char word;
		int index;
		int cnt;
		public BOJ(char word, int index, int cnt) {
			super();
			this.word = word;
			this.index = index;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "[" + word + ", " + index + ", " + cnt + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[] map = new char[1001];
		
		map = br.readLine().toCharArray();
		
		Queue<BOJ> que = new LinkedList<>();
		que.offer(new BOJ(map[0], 0, 0));
//		System.out.println(que);
		int ans = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			BOJ curr = que.poll();
			char now = curr.word;
			int nidx = curr.index;
			int cnt = curr.cnt;
			int k = 0;
			if (nidx==N-1) {
				ans=Math.min(ans, cnt);
			}
			if (now=='B') {
				for (int i = nidx+1; i < map.length; i++) {
					k++;
					if (map[i]=='O') {
						que.offer(new BOJ(map[i], i, cnt+k*k));
//						System.out.println(que);
//						break;
					}
				}
			}
			if (now=='O') {
				for (int i = nidx+1; i < map.length; i++) {
					k++;
					if (map[i]=='J') {
						que.offer(new BOJ(map[i], i, cnt+k*k));
//						System.out.println(que);
//						break;
					}
				}
			}
			if (now=='J') {
				for (int i = nidx+1; i < map.length; i++) {
					k++;
					if (map[i]=='B') {
						que.offer(new BOJ(map[i], i, cnt+k*k));
//						System.out.println(que);
//						break;
					}
				}
			}
			
		}
		if (ans<Integer.MAX_VALUE) {
			System.out.println(ans);			
		}else {
			System.out.println("-1");
		}
		
	}

}
