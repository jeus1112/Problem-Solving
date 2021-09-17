package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2470_두용액_G5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 5; t++) {
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		
		int start_idx = 0, end_idx = cards.length - 1;
		
		int min = 2000000000;
		int result1 = 0, result2 = 0;
		
		while ( end_idx > start_idx) {
			int sum = cards[start_idx] + cards[end_idx];
//			int temp = Math.abs(sum);
			if (Math.abs(min) > Math.abs(sum)) {
				min = sum;
				result1 = cards[start_idx];
				result2 = cards[end_idx];
			}
			if (sum > 0)
				end_idx--;
			else
				start_idx++;
		}
		System.out.println("=======");
		System.out.println(min);
		System.out.println(result1 + " " + result2);
		System.out.println("=======");
		}
	}
}

