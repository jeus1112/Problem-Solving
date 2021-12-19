package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_10871_X보다작은수_B3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            int A = Integer.parseInt(st.nextToken());
            if (A < X) {
                sb.append(A+" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
