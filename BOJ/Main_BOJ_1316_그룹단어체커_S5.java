package BOJ;

import java.io.*;

public class Main_BOJ_1316_그룹단어체커_S5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        int answer = TC;
        for (int t = 1; t <= TC; t++) {
            char[] word = br.readLine().toCharArray();
            boolean[] v = new boolean[26];
            v[word[0]-'a']=true;
            for (int i = 1; i < word.length; i++) {
                if (word[i - 1] != word[i] && !v[word[i] - 'a']) {
                    v[word[i]-'a']=true;
                }else if (word[i - 1] != word[i] && v[word[i] - 'a']) {
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}

/*
1
abba

0

 */