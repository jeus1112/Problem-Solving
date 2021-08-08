package BOJ;

import java.util.Scanner;

public class Main_BOJ_S3_15652_N과M4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] v = new boolean[N];
		int[] num = new int[M];
		perm(0, N, M, v, num);
		System.out.println(sb);
	}
	static StringBuilder sb = new StringBuilder();
	private static void perm(int cnt, int N, int M, boolean[] v, int[] num) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[i]+" ");
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			if (cnt-1>=0 && i+1<num[cnt-1]) {
				continue;
			}
			num[cnt]=i+1;
			perm(cnt+1, N, M, v, num);
		}
			
	}

}
