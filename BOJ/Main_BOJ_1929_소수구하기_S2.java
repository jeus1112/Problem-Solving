package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_1929_소수구하기_S2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[N + 1];
        prime[0]=true;
        prime[1]=true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!prime[i]) {
                for (int j = i + i; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}
//        for (int i = M; i <= N; i++) {
//            if (prime(i)) {
//                sb.append(i + "\n");
//            }
//        }
//        System.out.println(sb);
//    }
//
//    static boolean prime(int num) {
//        if (num < 2) {
//            return false;
//        }
//        for (int i = 2; i <= Math.sqrt(num); i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
