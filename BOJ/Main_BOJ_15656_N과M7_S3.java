package BOJ;

import java.io.*;
import java.util.*;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 중복순열
 *
 */
public class Main_BOJ_15656_N과M7_S3 {
    static int N, M;
    static int[] numbers, tmp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        tmp = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        perm(0);
        System.out.println(sb);
    }
    private static void perm(int cnt){
        if (cnt == M) {
            for (int i : tmp) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            tmp[cnt] = numbers[i];
            perm(cnt+1);
        }
    }
}
