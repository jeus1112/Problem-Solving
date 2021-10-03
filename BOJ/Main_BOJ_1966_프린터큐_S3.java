package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_1966_프린터큐_S3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 문서의 개수
            int M = Integer.parseInt(st.nextToken());   // 찾는 문서의 현재 queue 순번 0부터 시작
            Queue<Integer> que = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                que.offer(idx++); que.offer(tmp);
                pq.offer(tmp);
            }
            int ans = 0;
            a: while (true) {
                int important = pq.poll();
                while (true) {
                    int index = que.poll();
                    int imp = que.poll();
                    if (imp < important) {
                        que.offer(index);
                        que.offer(imp);
                    } else if (imp == important && index == M) {
                        ans++;
                        sb.append(ans + "\n");
                        break a;
                    } else {
                        ans++;
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
/*

3
1 0
5
4 2
1 2 3 4
6 0
1 1 9 1 1 1

*/
