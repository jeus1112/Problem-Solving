package PM;

import java.util.*;

/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 2021 카카오 채용연계형 인턴십
 *
 */
public class Solution_숫자문자열과영단어 {
    public int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);

        StringBuilder sb = new StringBuilder();
        String tmp = "";
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                sb.append(s.charAt(i));
                tmp = "";
            }else{
                tmp += s.charAt(i);
                if(map.containsKey(tmp)){
                    sb.append(map.get(tmp));
                    tmp = "";
                }
            }
        }

        int answer = Integer.parseInt(sb.toString());
        return answer;
    }
}
