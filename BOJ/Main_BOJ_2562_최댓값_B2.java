package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2562_최댓값_B2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] n = new int[9];
		for (int i = 0; i < n.length; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}

		int max = n[0];
		int index = 1;
		for (int i = 1; i < n.length; i++) {
			if (max <= n[i]) {
				max = n[i];
				index = i + 1 ;
			}
		}

		System.out.println(max);
		System.out.println(index);

	}

}


