package BOJ;

import java.io.*;

public class Main_BOJ_B1_1157_단어공부 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toUpperCase().toCharArray();
        int[] cnt = new int[26];
        int max = -1;
        for (int i = 0; i < word.length; i++) {
            cnt[word[i] - 65]++;
            max = Math.max(max, cnt[word[i] - 65]);
        }
        boolean flag = false;
        char ans = 'A';
        for (int i = 0; i < cnt.length; i++) {
            if (max == cnt[i] && flag) {
                System.out.println("?");
                System.exit(0);
            } else if (max == cnt[i] && !flag) {
                flag = true;
                ans = (char)(i+65);
            }
        }
        System.out.println(ans);
    }
}
