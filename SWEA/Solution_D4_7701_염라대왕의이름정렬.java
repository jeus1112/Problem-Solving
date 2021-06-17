package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author SHIM
 * @date 21.03.28
 */
public class Solution_D4_7701_염라대왕의이름정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] names = new String[N];
			for (int i = 0; i < N; i++) {
				names[i]=br.readLine();
			}
			Arrays.sort(names, new Comparator<String>() {
				public int compare(String a, String b) {
					if (a.length()==b.length()) {
						return a.compareTo(b);
					}
					return Integer.compare(a.length(), b.length());
				}
			});
			System.out.println("#"+t);
			System.out.println(names[0]);
			for (int i = 1; i < N; i++) {
				if (!names[i].equals(names[i-1])) {
					System.out.println(names[i]);
				}
			}
			
		}
	}
}
