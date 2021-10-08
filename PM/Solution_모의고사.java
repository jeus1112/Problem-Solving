package PM;

import java.util.*;

public class Solution_모의고사 {

    class Solution {
        public int[] solution(int[] answers) {

            // 1 2 3 4 5
            // 2 1 2 3 2 4 2 5
            // 3 3 1 1 2 2 4 4 5 5

            // i = i % n

            int[] num1 = {1, 2, 3, 4, 5};  // n = 5
            int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5}; // n = 8
            int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int[] correct = new int[3];

            for(int i = 0 ; i < answers.length; i++){
                if(answers[i]==num1[i%num1.length]){
                    correct[0]++;
                }
                if(answers[i]==num2[i%num2.length]){
                    correct[1]++;
                }
                if(answers[i]==num3[i%num3.length]){
                    correct[2]++;
                }
            }
            int max = Math.max(correct[0], Math.max(correct[1], correct[2]));
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < 3; i++){
                if(correct[i] == max){
                    list.add(i+1);
                }
            }
            int[] answer = new int[list.size()];
            for(int i = 0 ; i < list.size(); i++){
                answer[i]=list.get(i);
            }
            return answer;
        }
    }
}
