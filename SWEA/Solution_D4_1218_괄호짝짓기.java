package SWEA;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.04
 * @algorithm 
 * @version 1
 * 
 */
public class Solution_D4_1218_괄호짝짓기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <=10 ; t++) {
			
			int size = sc.nextInt();
			
			char[] str=sc.next().toCharArray();
			HashMap<Character, Character> map = new HashMap<>();
			map.put('(', ')');
			map.put('{', '}');
			map.put('[', ']');
			map.put('<', '>');
			Stack<Character> stack =new Stack<>();
			boolean possible = true;
			for (int i = 0; i < size; i++) {
				if(map.containsKey(str[i])) {
					stack.push(str[i]);		
				}else {
					if (!stack.isEmpty() && str[i]==map.get(stack.peek())) {
						stack.pop();
					}else {
						possible = false;
						break;
					}
				}
			}
			if (!stack.isEmpty()) possible =false;
			System.out.println("#"+t+" "+(possible?1:0));			
		}		
	}
}
