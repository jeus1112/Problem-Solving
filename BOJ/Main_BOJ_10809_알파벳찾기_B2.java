package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_10809_알파벳찾기_B2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] word = br.readLine().toCharArray();
        int[] answer = new int[26];
        Arrays.fill(answer,-1);
        for (int i = 0; i < word.length; i++) {
            if (answer[word[i]-97] == -1) {
                answer[word[i]-97]=i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length-1; i++) {
            sb.append(answer[i]+ " ");
        }
        sb.append(answer[answer.length - 1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
