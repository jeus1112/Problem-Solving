package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_11022_A플B_8_B3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append("Case #" + t + ": " + A + " + " + B + " = " + (A + B) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
