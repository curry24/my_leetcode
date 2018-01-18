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
	
		
//	�����ַ����е�һ�����ظ����ַ�
	public int firstUniqChar(String s){
		if(s == null) return -1;
//		ASCII��һ����256���ַ���
//		ǰ128��Ϊ���õ��ַ������������ĸ �����ֵȣ������Ͽ�����ʾ��
//		�� 128��Ϊ�����ַ����Ǽ������Ҳ������ַ�
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
