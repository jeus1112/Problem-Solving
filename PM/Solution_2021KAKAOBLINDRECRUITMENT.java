package PM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution_2021KAKAOBLINDRECRUITMENT {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] id = br.readLine().toCharArray();

		for (int i = 0; i < id.length; i++) {
			// 1단계
			int tmp = (int) id[i];
			if (65 <= tmp && tmp <= 90) {
				id[i] = (char) (tmp + 32);
			}
			sb.append(id[i]);
		}
		System.out.println("1단 " + sb.toString());
		id = sb.toString().toCharArray();

		sb.setLength(0); 
		for (int i = 0; i < id.length; i++) {
			int tmp = (int) id[i];
			// 2단계
			if ((97 <= tmp && tmp <= 122) || (48 <= tmp && tmp <= 57) || id[i] == '-' || id[i] == '_' || id[i] == '.') {
				sb.append(id[i]);
			}

		}
		System.out.println("2단 " + sb.toString());
		id = sb.toString().toCharArray();

		sb.setLength(0); 
		for (int i = 0; i < id.length; i++) {
			// 3단계
			if (i < id.length - 1 && id[i] == '.' && id[i + 1] == '.') {
				continue;
			}
			sb.append(id[i]);
		}
		System.out.println("3단 " + sb.toString());
		id = sb.toString().toCharArray();

		sb.setLength(0); 
		for (int i = 0; i < id.length; i++) {
			// 4단계
			if ((i == 0 || i == id.length - 1) && id[i] == '.') {
				continue;
			}
			sb.append(id[i]);
		}
		id = sb.toString().toCharArray();
		System.out.println("4단 " + sb.toString());

		// 5단계
		if (id.length == 0) {
			sb.setLength(0); 
			sb.append("a");
		}
		id = sb.toString().toCharArray();
		System.out.println("5단 " + sb.toString());

		// 6단계
		if (id.length >= 15) {
			sb.setLength(0); 
			for (int i = 0; i < 15; i++) {
				if (i==14 && id[i] == '.') {
					continue;
				}
				sb.append(id[i]);
			}
		}
		id = sb.toString().toCharArray();
		System.out.println("6단 " + sb.toString());

		// 7단계
		int n = id.length;
		System.out.println(n);
		if (1<=n && n <= 2) {
			sb.setLength(0); 
			for (int i = 0; i < n; i++) {
				sb.append(id[i]);
			}
			char x = id[n-1];
			while (true) {
				if (n == 3) {
					break;
				}
				sb.append(x);
				n++;
			}
		}
		System.out.println("7단 " + sb.toString());
		String answer = sb.toString();
		System.out.println(answer);
		
	}
}

/*
 * ...!@BaT#*..y.abcdefghijklm" → "...!@bat#*..y.abcdefghijklm
 * 
 */