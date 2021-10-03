package BOJ;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.03.23
 * @algorithm DP
 * 
 */
public class Main_BOJ_1463_1로만들기_S3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int D[] = new int[X+1];
		D[0]=0;
		D[1]=0;	// 1 -> 1
		
		for (int i = 2; i <= X; i++) {
			D[i]=D[i-1]+1;
			if (i%2==0) {
				D[i]=Math.min(D[i], D[i/2]+1);
			}
			if (i%3==0) {
				D[i]=Math.min(D[i], D[i/3]+1);
			}
		}
		
		
		System.out.println(D[X]);
		
	}
}
