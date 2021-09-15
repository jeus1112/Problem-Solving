package BOJ;

import java.io.*;

public class Main_BOJ_B2_2202_벌집 {
    public static void main(String[] args) throws Exception{
        // 1  2~7  8~19  20~37  38~61
        // 1   6    12     18   24

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int a = 1;
        int cnt = 1;
        for (int i = 1; ; i++) {
            if (N - a <= 0) {
                break;
            }
            a += 6*i;
            cnt++;
        }
        System.out.println(cnt);
    }
}
