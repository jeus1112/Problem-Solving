package SWEA;

import java.util.Scanner;

public class Solution_D2_1974_스도쿠검증 {
	static int T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int ans = 1; // 정답 맞으면 1 틀리면 0

			int[][] sudok = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudok[i][j] = sc.nextInt();
				}
			}
			// ===입력완료

			int[] nineR;
			int[] nineC;

			for (int i = 0; i < 9; i++) {
				nineR = new int[9];
				for (int j = 0; j < 9; j++) {
					nineR[sudok[i][j] - 1]++; // 행
				}
				for (int k = 0; k < 9; k++) {
					if (nineR[k] != 1) {
						ans = 0;
					}
				}
			}
			for (int i = 0; i < 9; i++) {
				nineC = new int[9];
				for (int j = 0; j < 9; j++) {
					nineC[sudok[j][i] - 1]++; // 열
				}
				for (int k = 0; k < 9; k++) {
					if (nineC[k] != 1) {
						ans = 0;
					}
				}
			}
//			012 012  345 012 678 012
			int[] nineS;
			nineS = new int[9];
			for (int i = 0; i < 3; i++) { // r 012
				for (int j = 0; j < 3; j++) { // 012
					nineS[sudok[i][j] - 1]++;
				}
			}
			for (int k = 0; k < 9; k++) {
				if (nineS[k] != 1) {
					ans = 0;
				}
			}
			nineS = new int[9];
			for (int i = 0; i < 3; i++) { // r 012
				for (int j = 3; j < 6; j++) { // 345
					nineS[sudok[i][j] - 1]++;
				}
			}
			for (int k = 0; k < 9; k++) {
				if (nineS[k] != 1) {
					ans = 0;
				}
			}
			nineS = new int[9];
			for (int i = 0; i < 3; i++) { // r 012
				for (int j = 6; j < 9; j++) { // 678
					nineS[sudok[i][j] - 1]++;
				}
			}
			for (int k = 0; k < 9; k++) {
				if (nineS[k] != 1) {
					ans = 0;
				}
			}
			nineS = new int[9];
			for (int i = 3; i < 6; i++) { // r 345
				for (int j = 0; j < 3; j++) { // 012
					nineS[sudok[i][j] - 1]++;
				}
			}
			for (int k = 0; k < 9; k++) {
				if (nineS[k] != 1) {
					ans = 0;
				}
			}
			nineS = new int[9];
			for (int i = 3; i < 6; i++) { // r 345
				for (int j = 3; j < 6; j++) { // 345
					nineS[sudok[i][j] - 1]++;
				}
			}
			for (int k = 0; k < 9; k++) {
				if (nineS[k] != 1) {
					ans = 0;
				}
			}
			nineS = new int[9];
			for (int i = 3; i < 6; i++) { // r 345
				for (int j = 6; j < 9; j++) { // 678
					nineS[sudok[i][j] - 1]++;
				}
			}
			for (int k = 0; k < 9; k++) {
				if (nineS[k] != 1) {
					ans = 0;
				}
			}
			nineS = new int[9];
			for (int i = 6; i < 9; i++) { // r 678
				for (int j = 0; j < 3; j++) { // 012
					nineS[sudok[i][j] - 1]++;
				}
			}
			for (int k = 0; k < 9; k++) {
				if (nineS[k] != 1) {
					ans = 0;
				}
			}
			nineS = new int[9];
			for (int i = 6; i < 9; i++) { // r 678
				for (int j = 3; j < 6; j++) { // 345
					nineS[sudok[i][j] - 1]++;
				}
			}
			for (int k = 0; k < 9; k++) {
				if (nineS[k] != 1) {
					ans = 0;
				}
			}
			nineS = new int[9];
			for (int i = 6; i < 9; i++) { // r 678
				for (int j = 6; j < 9; j++) { // 678
					nineS[sudok[i][j] - 1]++;
				}
			}
			for (int k = 0; k < 9; k++) {
				if (nineS[k] != 1) {
					ans = 0;
				}
			}

			// 출력
			System.out.println("#" + t + " " + ans);
		}

	}
}
