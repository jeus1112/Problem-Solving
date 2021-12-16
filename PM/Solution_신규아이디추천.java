package PM;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 2021 KAKAO BLIND RECRUITMENT
 *
 */
public class Solution_신규아이디추천 {
    public String solution(String new_id) {

        String answer = new_id.toLowerCase();   // 1단계

        answer = answer.replaceAll("[^a-z0-9-_.]","");  // 2단계

        answer = answer.replaceAll("[.]{2,}",".");  // 3단계

        // 4단계
        if(answer.charAt(0) == '.'){
            answer = answer.substring(1,answer.length());
        }
        if(answer.length() != 0 && answer.charAt(answer.length()-1)=='.'){
            answer = answer.substring(0, answer.length()-1);
        }

        // 5단계
        if(answer.equals("")){
            answer = "a";
        }

        // 6단계
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length()-1)=='.'){
                answer = answer.substring(0, answer.length()-1);
            }
        }

        // 7단계
        if(answer.length() <= 2){
            String tmp = answer.substring(answer.length()-1, answer.length());
            while(answer.length() < 3){
                answer += tmp;
            }
        }

        return answer;
    }
}
