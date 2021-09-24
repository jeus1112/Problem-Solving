package BOJ;

import java.io.*;

public class Main_BOJ_5622_다이얼_B2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 숫자 1=2초
        // 숫자 2=3초, ... , 9=10초, 0=11초
        // ABC DEF GHI JKL MNO PQRS TUV WXYZ
        // [0,1,2] [3,4,5] [6,7,8] [9,10,11] [12,13,14] [15,16,17,18] [19,20,21] [22,23,24,25]

        char[] word = br.readLine().toCharArray();
        int answer = 0;
        for (int i = 0; i < word.length; i++) {
            if ('A' <= word[i] && word[i] <= 'C') {
                answer += 3;
            }else if ('D' <= word[i] && word[i] <= 'F') {
                answer += 4;
            }else if ('G' <= word[i] && word[i] <= 'I') {
                answer += 5;
            }else if ('J' <= word[i] && word[i] <= 'L') {
                answer += 6;
            }else if ('M' <= word[i] && word[i] <= 'O') {
                answer += 7;
            }else if ('P' <= word[i] && word[i] <= 'S') {
                answer += 8;
            }else if ('T' <= word[i] && word[i] <= 'V') {
                answer += 9;
            }else if ('W' <= word[i] && word[i] <= 'Z') {
                answer += 10;
            }
        }
        System.out.println(answer);
    }
}
