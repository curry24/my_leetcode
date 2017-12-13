package top_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Phone_Number {
	public static void main(String []args){
		Scanner cin = new Scanner (System.in);
		String s = cin.next();
		Phone_Number a = new Phone_Number();
		List<String> out = new ArrayList();
		out = a.letterCombinations(s);
		System.out.print(out);
	}
	
	
	public List<String> letterCombinations(String digits){
		List<String> result = new ArrayList();
		if(digits == null||digits.length()==0) return result;
		Map<Character,String> map = new HashMap();
		map.put('0',"");
		map.put('1',"" );
		map.put('2',"abc");
		map.put('3',"def");
		map.put('4',"ghi");
		map.put('5',"jkl");
		map.put('6',"mno");
		map.put('7',"pqrs");
		map.put('8',"tuv");
		map.put('9',"wxyz");
		
		int n = digits.length();
		char temp[] = new char[n];
		dfs(digits,0,temp, map, result);
		
		return result;
		
	}
	
	public void dfs(String digits,int index,char temp[], Map<Character, String> map, List<String> result){
		
		int len = digits.length();
		if(index == len) 
		{	
			result.add(new String(temp));
			return;
		}
		
		char order = digits.charAt(index);
		String n = map.get(order);
		for(int i=0; i<n.length();i++){
			temp[index] = n.charAt(i);
			dfs(digits, index+1, temp, map, result);
		}
		
	}

}
