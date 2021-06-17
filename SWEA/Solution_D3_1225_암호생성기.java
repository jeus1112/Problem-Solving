package SWEA;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.04
 * @algorithm 
 * @version 1
 * 
 */
public class Solution_D3_1225_암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int j = 1; j <= 10; j++) {
			
			int t = sc.nextInt();
			Queue<Integer> que = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				que.offer(sc.nextInt());
			}
			int cnt = 1;
			while (true) {
				int n=que.poll() - cnt;
				if (n <= 0) {
					que.offer(0);
					break;
				}
				que.offer(n);
				cnt++;
				if (cnt > 5) {
					cnt = 1;
				}
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(que.poll() + " ");
			}
			System.out.println();
		}
		
		
	}
}
