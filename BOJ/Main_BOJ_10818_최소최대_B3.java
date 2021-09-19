package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_10818_최소최대_B3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            min = Math.min(min, tmp);
            max = Math.max(max, tmp);
        }
        System.out.println(min+" "+max);
    }
}
