package PM;

import java.util.Arrays;

public class Solution_위클리챌린지_2주차 {

	public static void main(String[] args) {
		
//		int[][] scores = {
//				{100,90,98,88,65}
//				,{50,45,99,85,77}
//				,{47,88,95,80,67}
//				,{61,57,100,80,65}
//				,{24,90,94,75,65}
//		};
//		int[][] scores = {
//				{50,90}
//				,{50,87}
//		};
		int[][] scores = {
				{70,49,90}
				,{68,50,38}
				,{73,31,100}
		};
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < scores.length; i++) {
			int total = 0;
			int avg = 0;
			int[] student = new int[scores.length];
			for (int j = 0; j < scores.length; j++) {
				student[j]=scores[j][i];
				total+=scores[j][i];
			}
			Arrays.sort(student);
			if ( (student[0] == scores[i][i]) && (student[0]!=student[1]) 
					|| (student[scores.length-1] == scores[i][i]) && (student[scores.length-1]!=student[scores.length-2])  ){
				total -= scores[i][i];
				avg = total/(scores.length-1);
			}else {
				avg = total/scores.length;
			}
			if (avg>=90) {
				sb.append("A");
			}else if (80 <= avg && avg<90) {
				sb.append("B");
			}else if (70 <= avg && avg<80) {
				sb.append("C");
			}else if (50 <= avg && avg<70) {
				sb.append("D");
			}else if ( avg<50) {
				sb.append("F");
			}
			
		}
		sb.toString();
		
		System.out.println(sb.toString());
		
	}
}
