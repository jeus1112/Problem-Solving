package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
/**
 * 
 * @author SHIM
 * @date 21.03.28
 */
public class Main_BOJ_1181_단어정렬_S5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] words = new String[N];
		
		for (int i = 0; i < N; i++) {
			words[i]=br.readLine();
		}
		
//		Arrays.sort(words);
//		for (int i = 0; i < N; i++) {
//			System.out.println(words[i]);
//		}
//		System.out.println("=======");
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String a, String b) {
				if (a.length()==b.length()) {
					return a.compareTo(b);
				}
				return Integer.compare(a.length(), b.length());
			}
		});
		
		System.out.println(words[0]);
		
		for (int i = 1; i < N; i++) {
			if (!words[i].equals(words[i-1])) {
				System.out.println(words[i]);
			}
		}
		
	}

}



