package BOJ;

import java.util.Scanner;

public class Main_BOJ_1149_RGB거리_S1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] RGB = new int[N][3];

        for (int i = 0; i < N; i++) {
            RGB[i][0]=sc.nextInt();
            RGB[i][1]=sc.nextInt();
            RGB[i][2]=sc.nextInt();
        }

        //RGB[i][0]+=Math.min(RGB[i-1][1], RGB[i-1][2])

        for (int i = 1; i < N; i++) {
            RGB[i][0]+=Math.min(RGB[i-1][1], RGB[i-1][2]);
            RGB[i][1]+=Math.min(RGB[i-1][0], RGB[i-1][2]);
            RGB[i][2]+=Math.min(RGB[i-1][0], RGB[i-1][1]);
        }

        int min = Math.min(RGB[N-1][0], RGB[N-1][1]);
        min = Math.min(min, RGB[N-1][2]);

        System.out.println(min);

    }
}
