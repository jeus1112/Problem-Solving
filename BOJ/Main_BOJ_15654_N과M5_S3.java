package BOJ;

import java.io.*;
import java.util.*;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 순열 사용.
 * 사전 순 증가를 위해 정렬을 하고 permutation
 * list에 담아서 출력할 때 : 91500KB | 2112ms
 * StringBuilder 사용 : 48240KB | 236ms
 * 많이 차이가 난다..
 *
 */
public class Main_BOJ_15654_N과M5_S3 {
    static int N, M;
    static int[] numbers, tmp;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        tmp = new int[M];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        perm(0);
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            for (int i : tmp) {
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (v[i]) continue;
            v[i]=true;
            tmp[cnt]=numbers[i];
            perm(cnt + 1);
            v[i]=false;
        }
    }
}
