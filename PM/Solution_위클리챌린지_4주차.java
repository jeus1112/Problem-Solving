package PM;

import java.util.*;

public class Solution_위클리챌린지_4주차 {
    public static void main(String[] args) {

        String[] table = {
                "SI JAVA JAVASCRIPT SQL PYTHON C#"
                , "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++"
                , "HARDWARE C C++ PYTHON JAVA JAVASCRIPT"
                , "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP"
                , "GAME C++ C# JAVASCRIPT C JAVA"
        };

        String[] languages = {
                "PYTHON"
                , "C++"
                , "SQL"
        };

        int[] preference = {7, 5, 5};

        String[] table2 = {
                "SI JAVA JAVASCRIPT SQL PYTHON C#"
                , "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++"
                , "HARDWARE C C++ PYTHON JAVA JAVASCRIPT"
                , "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP"
                , "GAME C++ C# JAVASCRIPT C JAVA"
        };

        String[] languages2 = {
                "JAVA"
                , "JAVASCRIPT"
        };

        int[] preference2 = {7, 5};

        System.out.println("----1----");
        System.out.println(solution(table,languages,preference));
        System.out.println("----2----");
        System.out.println(solution(table2,languages2,preference2));
    }
    static int[][] scores = {{5,4,2,5,1},{4,5,1,4,3},{0,0,5,0,2},{0,1,4,0,5},{1,0,0,0,4},{3,2,0,0,0},{2,3,3,3,0},{0,0,0,2,0},{0,0,0,1,0}};
    static String[] lang = {"JAVA", "JAVASCRIPT", "C", "C++" ,"C#" , "SQL", "PYTHON", "KOTLIN", "PHP"};
    static String[] job = {"SI", "CONTENTS", "HARDWARE", "PORTAL", "GAME"};
    public static String solution(String[] table, String[] languages, int[] preference) {
        int[] score = new int[5];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < languages.length; i++) {
            for (int j = 0; j < lang.length; j++) {
                if (languages[i].equals(lang[j])) {
                    for (int k = 0; k < 5; k++) {
                        score[k] += preference[i] * scores[j][k];
                        max = Math.max(max, score[k]);
                    }
                }
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0, idx=0; i < score.length; i++) {
            if (score[i] == max) {
                list.add(job[i]);
            }
        }
        Collections.sort(list);
        return list.get(0);
    }


}
