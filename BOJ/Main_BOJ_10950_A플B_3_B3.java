package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10950_A플B_3_B3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
        }
    }
}
