package BOJ;

import java.io.*;
import java.util.*;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 중복조합 + HashSet
 *
 */
public class Main_BOJ_15666_N과M12_S2 {
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
        comb(0,0);
        System.out.println(sb);
    }

    private static void comb(int cnt, int start) {
        if (cnt == M) {
            String s = "";
            for (int i : tmp) {
                s += i + " ";
            }
            if (!set.contains(s)) {
                sb.append(s + "\n");
            }
            set.add(s);
            return;
        }
        for (int i = start; i < N; i++) {
            tmp[cnt] = numbers[i];
            comb(cnt + 1, i);
        }
    }
}
