package top_interview;

import java.util.HashMap;
import java.util.Scanner;

public class First_Unique_Character_in_a_String {
	
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		String s = cin.next();
		First_Unique_Character_in_a_String a = new First_Unique_Character_in_a_String();
		System.out.println(a.firstUniqChar(s));
	}
	
	
//	public int firstUniqChar(String s){
//		if(s == null) return -1;
//		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//		for(int i=0;i<s.length();i++){
//			if(!map.containsKey(s.charAt(i)))  map.put(s.charAt(i), 1);
//			else{
//				int value = map.get(s.charAt(i));
//				value++;
//				map.put(s.charAt(i), value);
//			}
//		}
//		
//		for(int i=0;i<s.length();i++){
//			if(map.get(s.charAt(i)) == 1) return i;
//		}
//		return -1;
//	}
	
		
//	返回字符串中第一个非重复的字符
	public int firstUniqChar(String s){
		if(s == null) return -1;
//		ASCII码一共有256个字符，
//		前128个为常用的字符如运算符，字母 ，数字等，键盘上可以显示的
//		后 128个为特殊字符，是键盘上找不到的字符
		int[] record = new int[256];
		for(int i=0;i<s.length();i++){
			record[s.charAt(i)]++;
		}
		for(int i=0;i<s.length();i++){
			if(record[s.charAt(i)] == 1) return i;
		}
		return -1;
	}
}
