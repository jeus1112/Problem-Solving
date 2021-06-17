package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author JAEWOO SHIM
 * @date  21.04.15
 *	<문제>
 *	숫자와 연산자가 주어지면
 *	숫자와 연산자를 조합해서 최대와 최소를 찾는다
 *	<제약사항>
 *	숫자의 개수 N은 3이상 12이하의 정수
 *	연산자는 항상 N-1
 *	주어진 연산자를 모두 사용해야함
 *	숫자는 1~9
 *	숫자와 숫자 사이에는 연산자가 반드시 1개만
 *	완성된 수식을 계산할 때는 우선순위 없이 왼쪽에서 오른쪽으로 계산
 *	나눗셈의 소수점 이하는 버린다
 *	숫자의 순서는 고정이다
 *	연산 중의 값은 +-1억 이하이다.
 *	<입력>
 *	TC
 *	N 숫자의 개수
 *  각 연산자의 갯수 @ @ @ @ + - * '/'
 *  N개의 숫자가 공백을 두고 주어진다.
 *  <출력>
 *  최대값과 최소값의 차이를 구한다.
 */
public class Solution_모의_4008_숫자만들기 {

	static int N;
	static int[] oper;
	static int[] num;
	static int[] noper;
	static boolean[] v;
	static int max, min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());

			int[] tempoper = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				tempoper[i] = Integer.parseInt(st.nextToken());
			}
			oper = new int[N - 1];	// +=1 -=2 *=3 /=4
			noper = new int[N-1];
			v = new boolean[N-1];
			int idx = 0;
			for (int i = 0; i < tempoper.length; i++) {
				while(tempoper[i]>0) {
					oper[idx]=i+1;
					idx++;
					tempoper[i]--;
				}
			}
			num = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			perm(0);
			
			System.out.println("#"+t+" "+(max-min));

		}

	}
	private static void perm(int cnt) {
		if (cnt==N-1) {
			max = Math.max(max, calc());
			min = Math.min(min, calc());
			return;
		}
		for (int i = 0; i < N-1; i++) {
			if (v[i]) {
				continue;
			}
			v[i]=true;
			noper[cnt]=oper[i];
			perm(cnt+1);
			v[i]=false;
		}
	}
	static int calc() {
		int sum = num[0];
		for (int i = 0; i < N-1; i++) {
			if (noper[i]==1) {
				sum += num[i+1];
			}else if (noper[i]==2) {
				sum -= num[i+1];
			}else if (noper[i]==3) {
				sum *= num[i+1];
			}else if (noper[i]==4) {
				sum /= num[i+1];
			}
		}
		return sum;
	}
}

/*
1
5
2 1 0 1
3 5 3 7 9

24

1
6
4 1 0 0
1 2 3 4 5 6 

8

1
5
1 1 1 1
9 9 9 9 9 

144
*/

