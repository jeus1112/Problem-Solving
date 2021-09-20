package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_1008_A나누기B_B4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        System.out.println(A / B);
    }
}
