package BOJ;

import java.io.*;

public class Main_BOJ_1676_팩토리얼0의개수_S4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cntTwo = 0;
        int cntFive = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                cntTwo+=divideTwo(i);
            }
            if (i % 5 == 0) {
                cntFive+=divideFive(i);
            }
        }
        System.out.println(Math.min(cntTwo,cntFive));
    }
    static int divideTwo(int n){
        int cnt = 0;
        while (n % 2 == 0) {
            cnt++;
            n/=2;
        }
        return cnt;
    }
    static int divideFive(int n){
        int cnt = 0;
        while (n % 5 == 0) {
            cnt++;
            n/=5;
        }
        return cnt;
    }
}
