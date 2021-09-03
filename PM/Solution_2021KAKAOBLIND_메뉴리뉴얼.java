package PM;

import java.util.*;

/**
 * @Date : 2021-09-02 오후 11:48
 * @Author : JAEWOO SHIM
 *
 * orders 크기 2이상 20이하
 * orders 각 원소는 크기가 2이상 10이하
 * 각 문자열은 알파벳 대문자만, 중복 x
 *
 * course 크기 1이상 10이하
 * 오름차순 정렬, 중복x
 *
 * 각 코스요리 메뉴의 구성을 사전순으로 오름차순 정렬해서 return
 * 메뉴 구성이 여러개이면 모두 return
 * return 되는 배열의 길이는 반드시 1 이상이 되도록 TC 구성
 */
public class Solution_2021KAKAOBLIND_메뉴리뉴얼 {
    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2,3,5};

        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2,3,4};

        System.out.println(Arrays.toString(solution(orders,course)));
        System.out.println(Arrays.toString(solution(orders2,course2)));
        System.out.println(Arrays.toString(solution(orders3,course3)));
//        solution(orders, course);
    }

    static String[] solution(String[] orders, int[] course) {

        // order 최대 길이 체크, 두번 이상인거로 max

        // 같은게 두명이상 포함? -> max 최대
        // 아니면 max-1 만큼

        // 5C2 = 10 ab ac ad ae bc bd be cd ce de
        // 5c3 10

        // course 에서 뽑아서 갯수만큼 comb???

        // 10짜리로 20개 -> 10C2 = 45, 20개 -> 900개 -> list 가능?

        list = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <course.length; i++) {
            int r = course[i];
            templist = new ArrayList<>();
            for (int j = 0; j < orders.length; j++) {
                int n = orders[j].length();
                String[] str = orders[j].split("");
                Arrays.sort(str);
                temp = new String[r];
                comb(0,0,n,r,str);
            }

            int[] count = new int[list.size()];
            int maxCount = -1;
            for (String s : templist) {
                for (int idx = 0; idx < list.size(); idx++) {
                    if (s.equals(list.get(idx))) {
                        count[idx]++;
                        maxCount = Math.max(maxCount, count[idx]);
                    }
                }
            }
            for (int c = 0; c < count.length; c++) {
                if (count[c] == maxCount) {
                    ans.add(list.get(c));
                }
            }

        }
        Collections.sort(ans);
        String[] answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    static ArrayList<String> list;
    static String[] temp;
    static ArrayList<String> templist;
    static void comb(int cnt, int start, int n, int r, String[] str) {
        if (cnt == r) {
            StringBuilder sb = new StringBuilder();
            for (String s : temp) {
                sb.append(s);
            }
            // 2개 이상인거 넣고
            // 모든거 다 넣고
            // 2개이상 있는애들을 리스트로 해서
            // 모든거 다 있는거에서 체크
            String ss = sb.toString();
            if (templist.contains(ss) && !list.contains(ss)) {
                list.add(ss);
            }
            templist.add(ss);
            return;
        }
        for (int i = start; i < n; i++) {
            temp[cnt]=str[i];
            comb(cnt+1, i+1, n, r, str);
        }
    }
}
