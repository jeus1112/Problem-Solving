package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_2908_상수_B2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        sb.append(st.nextToken());
        int a = Integer.parseInt(sb.reverse().toString());
        sb = new StringBuffer();
        sb.append(st.nextToken());
        int b = Integer.parseInt(sb.reverse().toString());
        if (a > b) {
            System.out.println(a);
        }else{
            System.out.println(b);
        }
    }
}
