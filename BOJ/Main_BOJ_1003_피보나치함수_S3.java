package BOJ;

import java.io.*;

public class Main_BOJ_1003_피보나치함수_S3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];
        dp[0][0]=1;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=1;
        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i-1][0]+dp[i-2][0];
            dp[i][1] = dp[i-1][1]+dp[i-2][1];
        }
        for (int t = 1; t <= TC; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0] + " " + dp[N][1] + "\n");
        }
        System.out.print(sb);
    }
}
/*
0 1 1 2 3 5 8 13 21 34 ...

3
0
1
3

 */