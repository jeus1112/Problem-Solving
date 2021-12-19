package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ_1755_숫자놀이_S4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        // 입력 완료

        int size = N-M+1; // M부터 N까지의 개수는 N-M+1개 입니다.
        int[] nums = new int[size];
        int start = M;
        // M부터 N까지의 숫자를 nums배열에 넣어줍니다.
        for (int i = 0; i < size; i++) {
            nums[i]=start;
            start++;
        }

        String[] snum = new String[size];
//		 1 0 one zero
//		10/10 = 1
//		10%10 = 0
//		12/10 = 1
//		12%10 = 2
        // 위의 로직을 이용해 nums 배열의 수 들을 영어표기로 바꿔줍니다.
        for (int i = 0; i < size; i++) {
            int a = nums[i]/10;
            int b = nums[i]%10;
            StringBuilder sb = new StringBuilder();
            if (a==0) {
            }else if(a==1) {
                sb.append("one ");
            }else if(a==2) {
                sb.append("two ");
            }else if(a==3) {
                sb.append("three ");
            }else if(a==4) {
                sb.append("four ");
            }else if(a==5) {
                sb.append("five ");
            }else if(a==6) {
                sb.append("six ");
            }else if(a==7) {
                sb.append("seven ");
            }else if(a==8) {
                sb.append("eight ");
            }else if(a==9) {
                sb.append("nine ");
            }
            if (b==0) {
                sb.append("zero");
            }else if(b==1) {
                sb.append("one");
            }else if(b==2) {
                sb.append("two");
            }else if(b==3) {
                sb.append("three");
            }else if(b==4) {
                sb.append("four");
            }else if(b==5) {
                sb.append("five");
            }else if(b==6) {
                sb.append("six");
            }else if(b==7) {
                sb.append("seven");
            }else if(b==8) {
                sb.append("eight");
            }else if(b==9) {
                sb.append("nine");
            }
            snum[i]=sb.toString();
        }
        // snum을 사전 순으로 정렬해줍니다.
        Arrays.sort(snum, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        // 사전순으로 정렬된 snum을 ans배열에 숫자로 변환해서 넣어줍니다.
        String[] ans = new String[size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(snum[i]);
            StringBuilder sb = new StringBuilder();
            while(st.hasMoreTokens()) {
                String sn = st.nextToken();
                if (sn.equals("zero")) {
                    sb.append("0");
                }else if (sn.equals("one")) {
                    sb.append("1");
                }else if (sn.equals("two")) {
                    sb.append("2");
                }else if (sn.equals("three")) {
                    sb.append("3");
                }else if (sn.equals("four")) {
                    sb.append("4");
                }else if (sn.equals("five")) {
                    sb.append("5");
                }else if (sn.equals("six")) {
                    sb.append("6");
                }else if (sn.equals("seven")) {
                    sb.append("7");
                }else if (sn.equals("eight")) {
                    sb.append("8");
                }else if (sn.equals("nine")) {
                    sb.append("9");
                }
            }
            ans[i]=sb.toString();
        }
        //ans배열을 출력합니다. 한줄에 10개씩 출력하도록 cnt를 이용하였습니다.
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            System.out.print(ans[i]+" ");
            cnt++;
            if (cnt%10==0) {
                System.out.println();
            }
        }
    }

}
