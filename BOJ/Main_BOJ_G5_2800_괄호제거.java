package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main_BOJ_G5_2800_괄호제거 {
    static class ssang{
        int left;
        int right;

        public ssang(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "ssang{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static StringBuilder sb;
    static char[] susik;
    static ArrayList<ssang> ss;
    static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        susik = input.toCharArray();

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> idx = new ArrayList<>();
        ss = new ArrayList<>();
        ArrayList<Integer> sss = new ArrayList<>();
        for (int i = 0; i < susik.length; i++) {
            if (susik[i]=='('){
                stack.push(i);
            }
            if (susik[i] == ')') {
                int tmp = stack.pop();
                ss.add(new ssang(tmp, i));
                sss.add(tmp);
                sss.add(i);
            }
        }

        sb = new StringBuilder();
        v = new boolean[ss.size()];
        subset(0,ss.size());


        for (int i = 0; i < ss.size(); i++) {
            int li = ss.get(i).left;
            int ri = ss.get(i).right;
            for (int j = 0; j < susik.length; j++) {
                if (j == li || j == ri) {
                    continue;
                }
                sb.append(susik[j]);
            }
            sb.append("\n");
        }
            for (int j = 0; j < susik.length; j++) {
                if (sss.contains(j)) {
                    continue;
                }
                sb.append(susik[j]);
            }
            sb.append("\n");

        System.out.println(sb.toString());


    }

    static void subset(int cnt, int N) {
        if (cnt == N) {
            for (int i = 0; i < susik.length; i++) {

            }
            return;
        }
        v[cnt]=true;
        subset(cnt + 1, N);
        v[cnt]=false;
        subset(cnt+1, N);
    }

}
