package BOJ;

import java.util.*;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 재귀, 하노이
 *  move(N, 1, 2, 3){
 *      if(1<N){
 *          move(N-1, 1, 3, 2)
 *          move(1, 1, 2, 3)
 *          move(N-1, 3, 2, 1)
 *      }
 *  }
 *
 *  출력량이 많기 때문에 StringBuilder를 이용해야 시간초과가 나지 않는다.
 */
public class Main_BOJ_11729_하노이탑이동순서_S2 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(Math.round(Math.pow(2, N) - 1)); // 하노이 횟수 : 2^n - 1
        moveHanoi(N, 1, 2, 3);
        System.out.println(sb);
    }
    private static void moveHanoi(int n, int a, int b, int c){
        if ( 1 < n ){
            moveHanoi(n - 1, a, c, b);  // 1번 기둥에서 2번 기둥으로 n-1개 옮김
            moveHanoi(1, a, b, c);  // 1번 기둥에서 3번 기둥으로 밑바닥 옮김
            moveHanoi(n - 1, b, a, c);  // 2번 기둥에서 3번 기둥으로 n-1개 옮김
        }else{
            sb.append(a + " " + c + "\n");  // 출력할게 많아서 StringBuilder로 한번에 출력
//            System.out.println(a + " " + c);  // 이렇게하면 시간초과가 난다.
        }
    }
}
