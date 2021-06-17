package JO;
import java.util.Scanner;

public class Main_JO_1037_오류교정 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] matrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		//=====입력 완료
		int[] sero = new int[N];
		int[] garo = new int[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				garo[i] += matrix[i][j];
				sero[i] += matrix[j][i];
			}
		}
		int gg = 0 ;
		int gcnt = 0;
		int ss = 0;
		int scnt = 0;
		for (int i = 0; i < N; i++) {
			if (garo[i]%2!=0) {
				gg = i;
				gcnt++;
			}
			if (sero[i]%2!=0) {
				ss = i;
				scnt++;
			}
		}
		if (gcnt>1 || scnt>1) {
			System.out.println("Corrupt");
		}else if (gcnt == 0 && scnt == 0) {
			System.out.println("OK");
		}else {
			System.out.println("Change bit ("+(gg+1)+","+(ss+1)+")");
		}		
	}
}
