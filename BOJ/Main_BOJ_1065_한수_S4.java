package BOJ;

import java.util.*;

// 1자리수 2자리수는 모두 한수이다.
public class Main_BOJ_1065_한수_S4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int answer = 0;
        while (N > 0) {
            if (99<N && N <= 110) {
                answer += 99;
                break;
            } else if (N <= 99) {
                answer += N;
                break;
            }
            if (hannum(N)) {
                answer++;
            }
            N--;
        }
        System.out.println(answer);
    }

    private static boolean hannum(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            if (n / 10 == 0) {
                list.add(n);
                break;
            }
            list.add(n % 10);
            n /=10;
        }
        for (int i = 1; i < list.size()-1; i++) {
            if (list.get(i - 1) - list.get(i) != list.get(i) - list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
