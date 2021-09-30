package PM;

public class Solution_로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int cntZero = 0;
        int correct = 0;

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(lottos[i]==0){
                    cntZero++;
                    break;
                }
                if(lottos[i]==win_nums[j]){
                    correct++;
                    break;
                }
            }
        }
        int max = correct + cntZero;
        answer[0]=result(max);
        answer[1]=result(correct);

        return answer;
    }
    static int result(int cnt){
        if(cnt==6){
            return 1;
        }else if(cnt==5){
            return 2;
        }else if(cnt==4){
            return 3;
        }else if(cnt==3){
            return 4;
        }else if(cnt==2){
            return 5;
        }else {
            return 6;
        }
    }
}

