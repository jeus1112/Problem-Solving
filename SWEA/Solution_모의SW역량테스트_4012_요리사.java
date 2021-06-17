package SWEA;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.19
 * @algorithm 
 * @version 1
 * Solution_모의SW역량테스트_4012_요리사
 */
public class Solution_모의SW역량테스트_4012_요리사 {
	
	static int T;
	static int N;
	static int[][] table;
	static int ans;
	static int[] food;
	static int[] tlrwofy;
	
//	static int tot;
	
	static ArrayList<Integer> syn = new ArrayList<>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 1; t <= T ; t++) {
			
			N=sc.nextInt();
			
			table=new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					table[i][j]=sc.nextInt();
					
				}
			}
			food = new int[N/2];
			tlrwofy = new int[N];
			
			for (int i = 0; i < N; i++) {
				tlrwofy[i]=i;
			}
			nCr(0,0);
//			System.out.println("----------------");
			ans = Integer.MAX_VALUE;
			plus();
			syn.clear();
//			System.out.println(tot);
			System.out.println("#"+t+" "+ans);
		}
	}

	private static void nCr(int cnt, int start) {
		
		if (cnt==N/2) {
//			tot++;
			int k =0;
			for (int i = 0; i < N/2; i++) {
				for (int j = (N/2)-1; j >= 0; j--) {
//					System.out.println(table[food[i]][food[j]]);
					k += table[food[i]][food[j]];
				}
			}
			syn.add(k);
//			syn.add(table[food[0]][food[1]]+table[food[1]][food[0]]);
//			System.out.println(Arrays.toString(food));
//			System.out.println(food[0]+" "+food[1]);
//			System.out.println(syn);
			return;
		}
		for (int i = start; i < N; i++) {
			food[cnt]=tlrwofy[i];
			nCr(cnt+1, i+1);
		}
	}
	
	static void plus() {
		int syner = 0;
		for (int i = 0; i < syn.size()/2; i++) {
			syner = Math.abs(syn.get(i)-syn.get(syn.size()-i-1));
//			System.out.println(syner);
			ans = Math.min(syner, ans);
//			System.out.println(ans);
		}
	}

}









