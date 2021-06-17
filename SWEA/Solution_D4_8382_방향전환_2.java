package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution_D4_8382_방향전환_2 {
    static class Point{
        int r;
        int c;
        int cnt;
        boolean status;
        Point(int r, int c, boolean status){
            this.r = r;
            this.c = c;
            this.status = status;
        }
        @Override
        public boolean equals(Object obj) {
            Point p  = (Point) obj;
            return this.r == p.r && this.c == p.c;
        }
         
    }
    //하상우좌
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
        	// 범위 -100 <= (좌표) <= 100 이므로 양수로 땡겨서 입력
            int r = sc.nextInt() + 100;
            int c = sc.nextInt() + 100;
            int fr = sc.nextInt() + 100;
            int fc = sc.nextInt() + 100;
            Point dest = new Point(fr,fc, false); // 도착지점
            Queue<Point> queue = new LinkedList<>(); //큐 선언
            //앞의 2차원 좌표, 3차원은 방향의미
            boolean[][][] visited = new boolean[201][201][2];
            //시작점에서 두가지 모습상태로 출발
            queue.add(new Point(r, c,false));
            queue.add(new Point(r, c,true));
            visited[r][c][0] = true;
            visited[r][c][1] = true;
            int max = 0;
            while(!queue.isEmpty()) {
                Point p = queue.poll();
                //갱신
                max = Math.max(p.cnt, max);
                //목표에 도달하면 종료
                if( p.equals(dest)) {
                    break;
                }
                if( p.status ) {
                	//하상 방향
                    for(int i = 0; i < 2; i++) {
                        int nr = p.r + dr[i];
                        int nc = p.c + dc[i];
                        if(nr < 0 || nc < 0 || nr >= 201    || nc >= 201)
                            continue;
                        //이미 세로방향으로 방문을 했다면 방문x
                        if(visited[nr][nc][0])
                            continue;
                      //다음 포인트 생성후 cnt갱신 큐 push
                        Point nextP = new Point(nr,nc, !p.status);
                        nextP.cnt = p.cnt+1;
                        visited[nr][nc][0] = true;
                        queue.add(nextP);
                    }
                }
                else {
                	//우좌 방향
                    for(int i = 2; i < 4; i++) {
                        int nr = p.r + dr[i];
                        int nc = p.c + dc[i];
                        if(nr < 0 || nc < 0 || nr >= 201    || nc >= 201)
                            continue;
                        //이미 가로방향으로 방문을 했다면 방문x
                        if(visited[nr][nc][1])
                            continue;
                        //다음 포인트 생성후 cnt갱신 큐 push
                        Point nextP = new Point(nr,nc, !p.status);
                        nextP.cnt = p.cnt+1;
                        visited[nr][nc][1] = true;
                        queue.add(nextP);
                    }
                }
                 
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}