package BOJ;

import java.io.*;
import java.util.Stack;

public class Main_BOJ_S4_9012_괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        t: for (int t = 1 ; t <= TC ; t++){
            char[] arr = br.readLine().toCharArray();

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(') {
                    stack.push(arr[i]);
                } else if (arr[i] == ')' && !stack.isEmpty()) {
                    stack.pop();
                } else {
                    System.out.println("NO");
                    continue t;
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            }else
                System.out.println("NO");

        }
    }
}

/*

6
(())())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(

*/
