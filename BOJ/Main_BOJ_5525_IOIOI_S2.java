package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_5525_IOIOI_S2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();

        int ans = 0;
        int[] dist = new int[M];

        for (int i = 1; i < M - 1; i++) {
            if (arr[i] == 'O' && arr[i + 1] == 'I') {
                dist[i+1]=dist[i-1]+1;
                if (dist[i + 1] >= N && arr[i - 2 * N + 1] == 'I') {
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}
