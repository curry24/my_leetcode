package top_interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Longest_Substring_with_At_Least_K_Repeating_Characters {
	
	public static void main(String []args){
		
		Scanner cin = new Scanner(System.in);
		String s = cin.next();
		int k = cin.nextInt();
		Longest_Substring_with_At_Least_K_Repeating_Characters a = new Longest_Substring_with_At_Least_K_Repeating_Characters();
		System.out.print(a.longestSubstring(s, k));
		
	}
	
	public int longestSubstring(String s, int k) {
	
		int n = s.length();
		if(n==0||k==0) return 0;
		Map<Character, Integer> m = new HashMap();
		for(int i=0;i<n;i++){
			m.put(s.charAt(i), 1);
		}
        
    }

}
