package BOJ;

import java.io.*;
import java.util.*;

/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 숫자 버튼이 고장났다.. 캘린더는 안찢냐..
 * 버튼이 0~9까지 숫자, +와 -가 있다.
 * 0에서 -를 누르면 안변한다.
 * 보고 싶은 채널 N이 주어진다 (0 <= N <= 500000)
 * 고장난 버튼의 개수 M (0 <= M <= 10)
 * 고장난 버튼이 있으면 뭐가 고장났는지 보여준다.
 *
 * 초기채널 : 100
 *
 * 고장난 버튼이 없을 때를 생각해주지 않아서 런타임 에러 발생
 * if(M != 0) 으로 해결
 *
 */

public class Main_BOJ_1107_리모컨_G5 {
    static boolean[] broken;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        broken = new boolean[10];  //고장난 버튼은 true
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int a = Integer.parseInt(st.nextToken());
                broken[a]=true;
            }
        }
        int answer = Math.abs(100 - N); //초기값은 +, -만 이용해서 채널을 변경 할 경우

        for (int i = 0; i <= 999999; i++) {
            int press = checkNum(i);
            if (press > 0) { // 누르기 가능
                // 지금 누른 횟수 + N-i 만큼 +,- 누른 횟수
                answer = Math.min(answer, press + Math.abs(N - i));
            }
        }
        System.out.println(answer);

    }
    static int checkNum(int i){
        if (i == 0) {
            if (broken[0]) {
                return -1;
            }else{
                return 1;
            }
        }
        int cnt = 0;
        while (i > 0) {
            if (broken[i % 10]) {
                return -1;
            }
            i /= 10;
            cnt++;
        }
        return cnt;
    }
}

/*
101
0


 */