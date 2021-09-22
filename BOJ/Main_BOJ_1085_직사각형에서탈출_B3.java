package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_1085_직사각형에서탈출_B3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(Math.min(w - x, x), Math.min(h - y, y)));
    }
}
