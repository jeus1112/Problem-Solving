package BOJ;

import java.util.Scanner;

public class Main_BOJ_2846_오르막길_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] road = new int[N];
		for (int i = 0; i < N; i++) {
			road[i]=sc.nextInt();
		}
		
		// 입력 완료
		int sum = 0;
		int ans = 0;
		for (int i = 0; i < N-1; i++) {
			if (road[i]<road[i+1]) {
				sum+=road[i+1]-road[i];
				ans = Math.max(sum, ans);
			}else {
				sum=0;
			}
		}
		System.out.println(ans);
	}

}

/*8
12 3 5 7 10 6 1 11
*/

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int start = 0, prev = 0, len = 0, max = 0;
		len = Integer.parseInt(in.readLine());
	
		StringTokenizer st = new StringTokenizer(in.readLine());
		start = prev = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i < len; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(prev < num) {
				prev = num;
				if(i == len-1) {
					max = Math.max(max, prev-start);
				}
			}else {
				max = Math.max(max,  prev - start);
				start = num;
				prev = num;
			}
		}
		System.out.println(max);
	}

}

*/