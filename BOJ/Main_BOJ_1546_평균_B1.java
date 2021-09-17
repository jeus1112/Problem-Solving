package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1546_평균_B1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		double sum = 0;
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, score[i]);
			sum += score[i];
		}
		
		System.out.println(sum/max*100/N);
	}

}
