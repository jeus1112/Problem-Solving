package BOJ;

import java.io.*;
import java.util.*;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 *  누적합
 */
public class Main_BOJ_11659_구간합구하기4_S3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 1000으로 10만개이어도 1억이라 안전
        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(sum[b] - sum[a - 1]);
        }
    }
}
