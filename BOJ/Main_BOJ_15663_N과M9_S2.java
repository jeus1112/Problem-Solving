package BOJ;

import java.io.*;
import java.util.*;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * HashSet을 이용해서 중복 수열을 회피.
 *
 */
public class Main_BOJ_15663_N과M9_S2 {
    static int N, M;
    static int[] numbers, tmp;
    static StringBuilder sb = new StringBuilder();
    static boolean[] v;
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

    static HashSet<String> set = new HashSet<>();
    private static void perm(int cnt) {
        if (cnt == M) {
            String s = "";
            for (int i : tmp) {
                s += i;
                s += " ";
            }
            if (!set.contains(s)) {
                sb.append(s+"\n");
            }
            set.add(s);

            return;
        }
        for (int i = 0; i < N; i++) {
            if (v[i])continue;
            v[i] = true;
            tmp[cnt] = numbers[i];
            perm(cnt + 1);
            v[i] = false;
        }
    }
}
