package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**
 * 
 * @author SHIM
 * @date 21.03.28
 */
public class Main_BOJ_S5_11650_좌표정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][2];
		for (int i = 0; i < N; i++) {
			map[i][0]=sc.nextInt();
			map[i][1]=sc.nextInt();
		}
		Arrays.sort(map, new Comparator<int[]>() {
			public int compare(int a[], int b[]) {
				if (a[0]==b[0]) {
					return Integer.compare(a[1], b[1]);
				}
				return Integer.compare(a[0], b[0]);
			}
			
		});
		for (int i = 0; i < N; i++) {
			System.out.println(map[i][0]+" "+map[i][1]);
		}
	}

}
