package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_1620_나는야포켓몬마스터이다솜_S4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(Integer.toString(i), name);
            map.put(name, Integer.toString(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(map.get(br.readLine()) + "\n");
        }
        System.out.println(sb);
    }
}
