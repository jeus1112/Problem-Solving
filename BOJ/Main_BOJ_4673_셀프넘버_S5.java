package BOJ;

public class Main_BOJ_4673_셀프넘버_S5 {
    public static void main(String[] args) {
        boolean[] v = new boolean[10001];
        int n = 1;
        while (true) {
            int d = dn(n);
            if (d >= 10000) {
                break;
            } else {
                v[d-1]=true;
            }
            n++;
        }
        for (int i = 0; i < 9993; i++) {
            if (!v[i]) {
                System.out.println(i+1);
            }
        }
    }

    static int dn(int n) {
        if (n < 10) {
            return n + n;
        } else if (n < 100) {
            return n + (n / 10) + (n % 10);
        } else if (n < 1000) {
            return n + (n / 100) + ((n % 100) / 10) + (n % 10);
        } else {
            return n + (n / 1000) + ((n % 1000) / 100) + ((n % 100) / 10) + (n % 10);
        }
    }
}
