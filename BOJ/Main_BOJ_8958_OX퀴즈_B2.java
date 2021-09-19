package BOJ;

import java.io.*;

public class Main_BOJ_8958_OX퀴즈_B2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            char[] score = br.readLine().toCharArray();
            int answer = 0;
            int cnt = 0;
            for (int i = 0; i < score.length; i++) {
                if (score[i] == 'X') {
                    cnt = 0;
                }else{
                    cnt++;
                }
                answer += cnt;
            }
            System.out.println(answer);
        }
    }
}
