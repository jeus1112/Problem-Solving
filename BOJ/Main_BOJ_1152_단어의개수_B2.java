package BOJ;

import java.io.*;

public class Main_BOJ_1152_단어의개수_B2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.equals(" ")) {  // 공백 하나만 들어올 수도 있다.
            System.out.println("0");
            System.exit(0);
        }
        String[] ss = str.split(" ");
        if (ss[0].equals("")) {
            System.out.println(ss.length-1);
        }
        else{
            System.out.println(ss.length);
        }
    }
}
