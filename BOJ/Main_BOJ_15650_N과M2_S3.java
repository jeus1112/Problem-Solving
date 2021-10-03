package BOJ;

import java.util.Scanner;

public class Main_BOJ_15650_N과M2_S3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] v = new boolean[N];
		int[] num = new int[M];
		perm(0, 0, N, M, v, num);
	}
	static StringBuilder sb = new StringBuilder();
	private static void perm(int start, int cnt, int N, int M, boolean[] v, int[] num) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			if (v[i]) {
				continue;
			}
			v[i]=true;
			num[cnt] = i+1;
			perm(i+1,cnt+1, N, M, v, num);
			v[i]=false;
		}
			
	}

}
