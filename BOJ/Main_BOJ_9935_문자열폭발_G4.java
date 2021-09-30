package BOJ;

import java.io.*;
import java.util.*;
/**
 * @Date : 2021-08-27 오후 11:29
 * @Author : JAEWOO SHIM
 *
 * 문자열 배열을 while문을 이용해서 계속 탐색해서 지워줬더니
 * 시간초과 발생
 * -> stack을 사용해서 문자열을 지워주는 로직으로 짜야한다.
 *
 * String에 + 하는 식으로 짰더니
 * 메모리 초과 발생
 * -> StringBuilder로 해결
 *
 * stack에서 무턱대고 pop을 했더니
 * 틀렸습니다 발생
 * -> 폭탄인지 전체적으로 확인 후 폭탄 문자열 만큼 pop으로 해결
 *
 */
public class Main_BOJ_9935_문자열폭발_G4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> ss = new Stack<>();
        String[] str = br.readLine().split("");
        String[] bomb = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            ss.push(str[i]);
            if (ss.size() >= bomb.length && str[i].equals(bomb[bomb.length - 1])) {
                boolean flag = true;
                for (int j = bomb.length - 1,k=0; j >= 0; j--,k++) {
                    if (!ss.get(ss.size()-1-k).equals(bomb[j])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = bomb.length - 1; j >= 0; j--) {
                        ss.pop();
                    }
                }
            }

        }
        for (String s : ss) {
            sb.append(s);
        }
        if (sb.length()>0) {
            System.out.println(sb.toString());
        } else{
            System.out.println("FRULA");
        }
    }
}
