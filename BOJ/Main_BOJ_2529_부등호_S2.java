package BOJ;


import java.io.*;
import java.util.*;
/**
 * @Date : 2021-12-19 오후 6:04
 * @Author : JAEWOO SHIM
 *
 * 0-9까지 모두 넣을 때 int 범위를 벗어나는 경우가 있으므로
 * String 그대로 배열로 제일 앞, 뒤 인덱스를 출력
 *
 */
public class Main_BOJ_2529_부등호_S2 {
    static int[] n = {0,1,2,3,4,5,6,7,8,9};
    static int[] r;
    static boolean[] v;
    static int K;
    static char[] inequality;
    static ArrayList<String> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());    // 부등호 갯수
        r = new int[K + 1];
        v = new boolean[10];
        String tmp = br.readLine().replaceAll(" ","");
        inequality = tmp.toCharArray();
        list = new ArrayList<>();
        perm(0);
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }
    private static boolean check(int a, int b, char in){
        if (in == '<'){
            return a<b;
        }else {
            return a>b;
        }
    }
    private static void perm(int cnt){
        if(cnt == K+1){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r.length-1; i++){
                if (!check(r[i],r[i+1],inequality[i])){
                    return;
                }
                sb.append(r[i]);
            }
            sb.append(r[r.length - 1]);
            list.add(sb.toString());

            return;
        }
        for (int i = 0; i < n.length; i++){
            if(v[i]){
                continue;
            }
            v[i]=true;
            r[cnt]=n[i];
            perm(cnt+1);
            v[i]=false;
        }
    }
}
/*
2
< >
897
021
9
> < < < > > > < <
9567843012
1023765489
 */