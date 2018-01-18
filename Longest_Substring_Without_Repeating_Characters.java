package top_interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Longest_Substring_Without_Repeating_Characters {
      public static void main(String[] args){
    	  Scanner cin = new Scanner(System.in);
    	  String s = cin.next();
    	  System.out.print(s);
    	  Longest_Substring_Without_Repeating_Characters c = new Longest_Substring_Without_Repeating_Characters();
    	  System.out.print(c.lengthOfLongestSubString(s));
      }
      
//      public int lengthOfLongestSubString(String s){
//    		HashSet<Character> set = new HashSet<Character>();
//        	int maxnum=-1;
//        	int tem=0;
//        	char[] str = s.toCharArray();
//        	  for (int i=0;i<str.length;i++){
//        		  if(set.contains(str[i])){
//        			      tem=set.size();
//        			      maxnum = Math.max(maxnum,tem);
//        			      set.removeAll(set);
//        			  }
//        		  set.add(str[i]);
//        		  }
//        	    int last = set.size();
//        	    maxnum = Math.max(maxnum,last);
//        		return maxnum; 
//    	}
      
      public int lengthOfLongestSubString(String s){
    	  int n = s.length(), ans = 0;
          Map<Character, Integer> map = new HashMap(); // current index of character
          // try to extend the range [i, j]
          int i=0;
          for (int j = 0; j < n; j++) {
              if (map.containsKey(s.charAt(j))) {
                  i = Math.max(map.get(s.charAt(j)), i);
              }
              ans = Math.max(ans, j - i + 1);
              map.put(s.charAt(j), j + 1);
          }
          return ans;
      	 
      	}
    	
}
