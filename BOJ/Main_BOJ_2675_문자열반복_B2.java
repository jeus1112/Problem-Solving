package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_2675_문자열반복_B2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String[] ss = st.nextToken().split("");
            for (int i = 0; i < ss.length; i++) {
                for (int j = 0; j < R; j++) {
                    sb.append(ss[i]);
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
