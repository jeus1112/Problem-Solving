package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_BOJ_15683_감시_G5 {
    static class CCTV{
        int r;
        int c;
        public CCTV(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
        @Override
        public String toString() {
            return "[" + r + ", " + c + "]";
        }

    }
    static int N, M;
    static int[][] map;
    static int[][] copy;
    static ArrayList<CCTV> cctv;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        copy = new int[N][M];
        cctv = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j]=sc.nextInt();
                if (0<map[i][j] && map[i][j]<6) {
                    cctv.add(new CCTV(i, j));
                }
            }
        }
        // 입력완료

        // 리스트에 있는걸 하나씩 뽑아서 해당 칸을 돌리고 그 다음 꺼를 돌리고
        ans = Integer.MAX_VALUE;
//		copy=copy(map);
        ctv(map, 0);
        System.out.println(ans);

    }
    private static int[][] copy(int[][] arr) {
        int[][] copyarr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyarr[i][j]=arr[i][j];
            }
        }
        return copyarr;
    }
    private static void ctv(int[][] arr, int idx) {
        int[][] tmp = copy(arr);
//		int[][] tmp2 = copy(arr);
        if (idx>cctv.size()-1) {
            int cnt =0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tmp[i][j]==0) {
                        cnt++;
                    }
                }
            }
            ans = Math.min(ans, cnt);
            return;
        }
        int r = cctv.get(idx).r;
        int c = cctv.get(idx).c;
        int num = map[r][c];
//		int n = checknum(map[r][c]);

        if (num==1) {
            for (int d = 0; d < 4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                while(check(nr,nc)) {
                    if (0<tmp[nr][nc] && tmp[nr][nc]<6) {
                        nr += dr[d];
                        nc += dc[d];
                        continue;
                    }
                    if (tmp[nr][nc]==6) {
                        break;
                    }
                    tmp[nr][nc]=7;
                    nr += dr[d];
                    nc += dc[d];
                }
                ctv(tmp, idx+1);
                tmp = copy(arr);
            }
        }
        if (num==2) {
            // 상하 || 좌우
            for (int i = 0; i < 2; i++) {
                int d = i%4;
                int nr = r + dr[d];
                int nc = c + dc[d];
                int nr2 = r + dr[d+2];
                int nc2 = c + dc[d+2];
                while(check(nr,nc)) {
                    if (0<tmp[nr][nc] && tmp[nr][nc]<6) {
                        nr += dr[d];
                        nc += dc[d];
                        continue;
                    }
                    if (tmp[nr][nc]==6) {
                        break;
                    }
                    tmp[nr][nc]=7;
                    nr += dr[d];
                    nc += dc[d];
                }
                while(check(nr2,nc2)) {
                    if (0<tmp[nr2][nc2] && tmp[nr2][nc2]<6) {
                        nr2 += dr[d+2];
                        nc2 += dc[d+2];
                        continue;
                    }
                    if (tmp[nr2][nc2]==6) {
                        break;
                    }
                    tmp[nr2][nc2]=7;
                    nr2 += dr[d+2];
                    nc2 += dc[d+2];
                }
                ctv(tmp, idx+1);
                tmp = copy(arr);
            }
        }
        if (num==3) {
            // 상우01 우하12 하좌 23 좌상 30
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                int nr2 = r + dr[(d+1)%4];
                int nc2 = c + dc[(d+1)%4];
                while(check(nr,nc)) {
                    if (0<tmp[nr][nc] && tmp[nr][nc]<6) {
                        nr += dr[d];
                        nc += dc[d];
                        continue;
                    }
                    if (tmp[nr][nc]==6) {
                        break;
                    }
                    tmp[nr][nc]=7;
                    nr += dr[d];
                    nc += dc[d];
                }
                while(check(nr2,nc2)) {
                    if (0<tmp[nr2][nc2] && tmp[nr2][nc2]<6) {
                        nr2 += dr[(d+1)%4];
                        nc2 += dc[(d+1)%4];
                        continue;
                    }
                    if (tmp[nr2][nc2]==6) {
                        break;
                    }
                    tmp[nr2][nc2]=7;
                    nr2 += dr[(d+1)%4];
                    nc2 += dc[(d+1)%4];
                }
                ctv(tmp, idx+1);
                tmp = copy(arr);
            }
        }
        if (num==4) {
            // 상우하012 우하좌123 하좌상230 좌상우301
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                int nr2 = r + dr[(d+1)%4];
                int nc2 = c + dc[(d+1)%4];
                int nr3 = r + dr[(d+2)%4];
                int nc3 = c + dc[(d+2)%4];
                while(check(nr,nc)) {
                    if (0<tmp[nr][nc] && tmp[nr][nc]<6) {
                        nr += dr[d];
                        nc += dc[d];
                        continue;
                    }
                    if (tmp[nr][nc]==6) {
                        break;
                    }
                    tmp[nr][nc]=7;
                    nr += dr[d];
                    nc += dc[d];
                }
                while(check(nr2,nc2)) {
                    if (0<tmp[nr2][nc2] && tmp[nr2][nc2]<6) {
                        nr2 += dr[(d+1)%4];
                        nc2 += dc[(d+1)%4];
                        continue;
                    }
                    if (tmp[nr2][nc2]==6) {
                        break;
                    }
                    tmp[nr2][nc2]=7;
                    nr2 += dr[(d+1)%4];
                    nc2 += dc[(d+1)%4];
                }
                while(check(nr3,nc3)) {
                    if (0<tmp[nr3][nc3] && tmp[nr3][nc3]<6) {
                        nr3 += dr[(d+2)%4];
                        nc3 += dc[(d+2)%4];
                        continue;
                    }
                    if (tmp[nr3][nc3]==6) {
                        break;
                    }
                    tmp[nr3][nc3]=7;
                    nr3 += dr[(d+2)%4];
                    nc3 += dc[(d+2)%4];
                }
                ctv(tmp, idx+1);
                tmp = copy(arr);
            }
        }
        if (num==5) {
            // 상우하012 우하좌123 하좌상230 좌상우301
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                while(check(nr,nc)) {
                    if (0<tmp[nr][nc] && tmp[nr][nc]<6) {
                        nr += dr[d];
                        nc += dc[d];
                        continue;
                    }
                    if (tmp[nr][nc]==6) {
                        break;
                    }
                    tmp[nr][nc]=7;
                    nr += dr[d];
                    nc += dc[d];
                }
            }
            ctv(tmp, idx+1);
        }
    }
    private static boolean check(int r, int c) {
        return r>=0 && r<N && c>=0 &&c<M;
    }
    static int checknum(int a) {
        if (a==1) {
            return 4;
        }
        if (a==2) {
            return 2;
        }
        else if (a==3) {
            return 4;
        }
        else if (a==4) {
            return 4;
        }
        else{
            return 1;
        }
    }
}
