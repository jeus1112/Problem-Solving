package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_1182_부분수열의합_S2 {
    static int N, S;
    static int ans;
    static int[] arr;
    static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        v = new boolean[N];
        ans = 0;
        subset(0, 0);
        System.out.println(ans);

    }

    private static void subset(int cnt, int sum) {
        if (cnt== N) {
            int c = 0;
            for (int i = 0; i < N; i++) {
                if (v[i]) {
                    c++;
                }
            }
            if (sum==S && c!=0) {
                ans++;
            }
            return;
        }
        v[cnt]=true;
        subset(cnt+1,sum+arr[cnt]);
        v[cnt]=false;
        subset(cnt+1, sum);
    }
}
