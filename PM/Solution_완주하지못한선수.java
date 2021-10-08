package PM;

import java.util.*;

public class Solution_완주하지못한선수 {

    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < completion.length; i++){
                // map.put(completion[i], map.getOrDefault(completion[i],0)+1);
                if(map.containsKey(completion[i])){
                    map.replace(completion[i], map.get(completion[i])+1);
                }else{
                    map.put(completion[i],1);
                }
            }
            boolean flag = false;
            for(int i =0; i< participant.length; i++){
                if(map.containsKey(participant[i])){
                    map.replace(participant[i], map.get(participant[i])-1);
                }else{
                    answer = participant[i];
                    flag = true;
                    break;
                }
            }
            if(flag){
                return answer;
            }else{
                for(int i = 0; i < completion.length; i++){
                    if(map.get(completion[i])!=0){
                        answer = completion[i];
                    }
                }
                return answer;
            }
        }
    }
}
