package BOJ;

import java.io.*;
import java.util.*;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 조합을 이용.
 * 순서를 위해 numbers를 정렬 후 조합.
 * StringBuilder를 이용해 시간을 단축.
 *
 */
public class Main_BOJ_15655_N과M6_S3 {
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
        comb(0,0);
        System.out.println(sb);
    }
    private static void comb(int cnt, int start){
        if (cnt == M) {
            for (int i : tmp) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            tmp[cnt]=numbers[i];
            comb(cnt + 1, i + 1);
        }
    }
}
