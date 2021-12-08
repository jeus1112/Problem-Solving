package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_1920_수찾기_S4 {
    static int N;
    static int[] A;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            long key = Long.parseLong(st.nextToken());
            if (binarySearch(key)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }

    static boolean binarySearch(long key) {
        int high = N-1;
        int low = 0;
        int mid = 0;
        while (low <= high) {
            mid = (low+high)/2;
            if (key < A[mid]) {
                high = mid -1;
            } else if (key > A[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
