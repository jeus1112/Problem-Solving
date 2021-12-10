package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_1978_소수찾기_S4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (prime(Integer.parseInt(st.nextToken()))) {
                answer++;
            }
        }
        System.out.println(answer);
    }
    static boolean prime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
