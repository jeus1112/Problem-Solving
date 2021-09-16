package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_B2_13458_시험감독 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        double[] people = new double[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long answer = 0;    // 답이 최대가 될때 int 범위를 넘길 수 있음
        for (int i = 0; i < N; i++) {
            people[i] -= B;
            answer++;
            if (people[i] <= 0) {
                continue;
            }
            answer += Math.ceil(people[i] / C);
        }
        System.out.println(answer);
    }
}
