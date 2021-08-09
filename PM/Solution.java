package PM;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] gift_cards = {4,5,3,2,1};
		int[] wants = {2,4,4,5,1};
//		int[] gift_cards = {5,4,5,4,5};
//		int[] wants = {1,2,3,5,4};
		
		int answer = 0;
		
		int n = wants.length;
		boolean[] v = new boolean[100001];
		int cnt =0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (wants[i]==gift_cards[j] && !v[j]) {
					v[j]=true;
					cnt++;
					break;
				}
			}
		}
		answer= n-cnt;
		System.out.println(answer);
		
	}*/
	/*static int R;
	static int[] p;
	static int[] num;
	static int y;
	static int[][] copy;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] needs = {
				{1,0,0},
				{1,1,0},
				{1,1,0},
				{1,0,1},
				{1,1,0},
				{0,1,1}
		};
		
		int r = sc.nextInt();
		y = needs[0].length;
		copy = needs;
		p = new int[y];
		num = new int[r];
		for (int i = 0; i < y; i++) {
			p[i]=i;
		}
		R=r;
		ans = Integer.MIN_VALUE;
		nCr(0,0);
		System.out.println(ans);
	}
	static void nCr(int cnt, int start) {
		if (cnt==R) {
			int tot = 0;
			int check = 0;
			for (int i = 0; i < copy.length; i++) {
				for (int j = 0; j < copy[i].length; j++) {
					check+=copy[i][j];
				}
				if (check==1 && (copy[i][num[0]]==1 || copy[i][num[1]]==1)) {
					tot++;
				}
				if(copy[i][num[0]]==1 && copy[i][num[1]]==1) {
					tot++;
				}
			}
			ans = Math.max(ans, tot);
			return;
		}
		for (int i = start; i < y; i++) {
			
			num[cnt]=p[i];
			nCr(cnt+1, i+1);
		}
	}*/
	
	public static void main(String[] args) {
		int[] passenger = {1,1,1,1,1,1};
		int[][] train = {
				{1,2},
				{1,3},
				{1,4},
				{3,5},
				{3,6}
		};
		
		
		int ans = 0;
		int end = 0;
		boolean[] v = new boolean[passenger.length+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1); q.offer(passenger[0]);
		v[1]=true;
		while(!q.isEmpty()) {
			int now = q.poll();
			int pass = q.poll();
			for (int i = 0; i < train.length; i++) {
				if (train[i][0]==now) {
					int next = train[i][1];
					int nextpass = pass + passenger[next-1];
					if (v[next]) {
						continue;
					}
					q.offer(next);
					v[next]=true;
					q.offer(nextpass);
					if (ans <= nextpass) {
						ans = nextpass;
						end = Math.max(end, next);
					}
				}
			}
		}
		int[] answer = {end, ans};
		System.out.println(Arrays.toString(answer));
	}
}























