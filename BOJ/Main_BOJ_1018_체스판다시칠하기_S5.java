package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_1018_체스판다시칠하기_S5 {
    static class chessMap{
        int r;
        int c;
        char color;

        public chessMap(int r, int c, char color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }
    static int N,M;
    static char[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i]=br.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                if (map[i][j] == 'B') {
                    answer = Math.min(answer,chessCheck('B', i, j));
                    answer = Math.min(answer,chessCheck('W', i, j)+1);
                } else {
                    answer = Math.min(answer,chessCheck('W', i, j));
                    answer = Math.min(answer,chessCheck('B', i, j)+1);
                }
            }
        }
        System.out.println(answer);
    }
    static int[] dr = {-1,1,0,0};  // 상하좌우
    static int[] dc = {0,0,-1,1};
    static int chessCheck(char bw, int sr, int sc) {
        int cnt = 0;
        Queue<chessMap> que = new LinkedList<>();
        boolean[][] v = new boolean[N][M];
        que.offer(new chessMap(sr, sc, bw));
        v[sr][sc]=true;
        while (!que.isEmpty()) {
            int curR = que.peek().r;
            int curC = que.peek().c;
            char curColor = que.poll().color;

            for (int d = 0; d < 4; d++) {
                int nr = curR + dr[d];
                int nc = curC + dc[d];

                if (!check(sr, sc, nr, nc)) {
                    continue;
                }
                if (v[nr][nc]) continue;
                if (map[nr][nc] != curColor) {
                    que.offer(new chessMap(nr, nc, map[nr][nc]));
                    v[nr][nc]=true;
                }else if(map[nr][nc] == curColor && curColor=='B'){
                    que.offer(new chessMap(nr, nc, 'W'));
                    v[nr][nc]=true;
                    cnt++;
                }else if(map[nr][nc] == curColor && curColor=='W'){
                    que.offer(new chessMap(nr, nc, 'B'));
                    v[nr][nc]=true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static boolean check(int sr, int sc, int nr, int nc) {
        return nr>=sr && nr<(sr+8) && nc>=sc && nc<(sc+8);
    }
}
