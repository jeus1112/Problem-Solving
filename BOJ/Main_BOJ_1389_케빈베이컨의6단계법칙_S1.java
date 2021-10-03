package BOJ;

import java.io.*;
import java.util.*;

/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 플로이드 워샬
 *
 */
public class Main_BOJ_1389_케빈베이컨의6단계법칙_S1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 유저의 수
        int M = Integer.parseInt(st.nextToken());   // 친구 관계의 수
        int[][] arr = new int[N][N];
        int INF = 1000000;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    arr[i][j]=INF;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            arr[a][b]=arr[b][a]=1;
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][k] + arr[k][j] < arr[i][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        int[] kevinBacon = new int[N];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum+=arr[i][j];
            }
            kevinBacon[i]=sum;
            min = Math.min(min, sum);
        }
        for (int i = 0; i < N; i++) {
            if (kevinBacon[i] == min) {
                System.out.println(i+1);
                break;
            }
        }

    }
}
