package BOJ;

import java.io.*;
import java.util.*;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 중복순열 + HashSet
 *
 */
public class Main_BOJ_15665_N과M11_S2 {
    static int N, M;
    static int[] numbers, tmp;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>();
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

    private static void perm(int cnt) {
        if (cnt == M) {
            String s = "";
            for (int i : tmp) {
                s += i;
                s += " ";
            }
            if (!set.contains(s)) {
                sb.append(s + "\n");
            }
            set.add(s);
            return;
        }
        for (int i = 0; i < N; i++) {
            tmp[cnt] = numbers[i];
            perm(cnt + 1);
        }
    }
}
