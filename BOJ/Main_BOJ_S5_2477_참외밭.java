package BOJ;

import java.util.Scanner;

public class Main_BOJ_S5_2477_참외밭 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        int[] cham = new int[6];
        int w = 0;
        int h = 0;
        int wi = 0;
        int hi = 0;
        int x = 0;
        for (int i = 0; i < 6; i++) {
            x = sc.nextInt();
            cham[i] = sc.nextInt();
            if (x == 1 || x == 2) {
                w = Math.max(w, cham[i]);
                if (w == cham[i]) {
                    wi = i;
                }
            }
            if (x == 3 || x == 4) {
                h = Math.max(h, cham[i]);
                if (h == cham[i]) {
                    hi = i;
                }
            }
        }
        int a = 0;
        int b = 0;
        if (wi + 3 >= 6) {
            wi = wi + 3 - 6;
            a = cham[wi];
        } else {
            a = cham[wi + 3];
        }
        if (hi + 3 >= 6) {
            hi = hi + 3 - 6;
            b = cham[hi];
        } else {
            b = cham[hi + 3];
        }
        int ans = w * h - a * b;
        System.out.println(ans * K);
    }
}
