package top_interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Longest_substring_03 {
	public static void main(String[] args){
    	Scanner cin = new Scanner(System.in);
    	String s = cin.next();
    	    
    	Longest_substring_03 a = new Longest_substring_03();
    	System.out.print(a.lengthOfLongestSubstring(s));
    	}
    	
     
	
//	public int lengthOfLongestSubstring(String s){
//			
//		int n = s.length();
//		if(n==0) return 0;	
//		int longest =1;
//		for(int i=0;i<n;i++){
//			for(int j=i+1;j<n;j++)
//				if(isUnique(i,j,s)) longest = Math.max(longest, j-i+1); 
//		}
//		return longest;
//		
//	}
//	
//	public boolean isUnique(int start,int end,String s){
//		Set<Character> a = new HashSet<>();
//		for (int i=start;i<=end;i++){
//			if(a.contains(s.charAt(i))) return false;
//			else a.add(s.charAt(i));
//		}
//		return true;		
//	}
	
	
	public int lengthOfLongestSubstring(String s){
		Map<Character, Integer> a = new HashMap();
		int n = s.length();
		if(n==0) return 0;
		int longest = 1;
		for(int i=0,j=0;j<n;j++){
			if(a.containsKey(s.charAt(j))){				
				i = Math.max(a.get(s.charAt(j))+1, i);
			}		
			longest = Math.max(j-i+1,longest);
			a.put(s.charAt(j), j);
		}
		
		return longest;
	}
	
	

}
