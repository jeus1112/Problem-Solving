package BOJ;

import java.io.*;

public class Main_BOJ_B2_11720_숫자의합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] numbers = br.readLine().toCharArray();
        int answer = 0;
        for (char c : numbers) {
            answer += c-'0';
        }
        System.out.println(answer);
    }
}
