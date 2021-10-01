package PM;

public class Solution_행렬테두리회전하기 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {
                {2, 2, 5, 4}
                , {3, 3, 6, 6}
                , {5, 1, 6, 3}
        };
        int rows1 = 3;
        int columns1 = 3;
        int[][] queries1 = {
                {1, 1, 2, 2}
                , {1, 2, 2, 3}
                , {2, 1, 3, 2}
                , {2, 2, 3, 3}
        };
        int rows2 = 100;
        int columns2 = 97;
        int[][] queries2 = {
                {1, 1, 100, 97}
        };
        print(solution(rows,columns,queries));
    }
    static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                arr[i][j]=(i*columns + (j+1));
            }
        }

        for(int i = 0; i < queries.length; i++){
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            int min = arr[x1][y1];
            int tmp = arr[x1][y1]; // 시작점을 빼놓고
            // x1,y1 = x1+1,y1  x1+1,y1 = x1+2,y1  ... x2-1,y1 = x2,y1
            // x2,y1 = x2,y1+1 x2,y1+1 = x2,y1+2 ... x2,y2-1 = x2,y2
            // x2,y2 = x2-1,y2 x2-1,y2 = x2-2,y2 ... x1+1,y2 = x1,y2
            // x1,y2 = x1,y2-1 x1,y2-1 = x1,y2-2 ... x1,y1+2 = x1,y1+1  y1+1 = tmp
            for(int k = 0; k <= x2-x1-1; k++){
                arr[x1+k][y1] = arr[x1+k+1][y1];
                min = Math.min(arr[x1+k+1][y1], min);
            }
            for(int k = 0; k <= y2-y1-1; k++){
                arr[x2][y1+k] = arr[x2][y1+k+1];
                min = Math.min(arr[x2][y1+k+1], min);
            }
            for(int k = 0; k <= x2-x1-1; k++){
                arr[x2-k][y2] = arr[x2-k-1][y2];
                min = Math.min(arr[x2-k-1][y2], min);
            }
            for(int k = 0; k <= y2-y1-2; k++){
                arr[x1][y2-k] = arr[x1][y2-k-1];
                min = Math.min(arr[x1][y2-k-1], min);
            }
            arr[x1][y1+1]=tmp;

            answer[i] = min;

        }

        return answer;
    }

    static void print(int[] answer){
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]+" ");
        }
    }
}
