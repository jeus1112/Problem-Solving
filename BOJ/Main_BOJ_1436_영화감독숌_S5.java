package BOJ;

import java.util.*;

public class Main_BOJ_1436_영화감독숌_S5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int num = 666;
        while (true) {
            if (String.valueOf(num).contains("666")) {
                N--;
            }
            if (N == 0) {
                System.out.println(num);
                System.exit(0);
            }
            num++;
        }

    }
}