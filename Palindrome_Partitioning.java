package top_interview;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
	public static void main(String[] args){
		String s = "cdd";
		List<List<String>> result = new ArrayList();
		Palindrome_Partitioning a = new Palindrome_Partitioning();
		result = a.partition(s);
		System.out.println(result);
	}
	
//	�����Ҫ���ǣ�����һ���ַ�������Ҫ���ַ����ָ�����ɻ����Ӵ�����Ҫ�������еĿ��ܵ����
//	(���ķָ�)
//	��ˣ�������Ҫ�õݹ�(DFS)�����н��
//	ʵ���ϣ������� Word_Break ��Ŀ���񣬶�����ѭ���ڲ������жϣ�������ĳ������������еݹ����
	public List<List<String>> partition(String s){
		List<String> temp = new ArrayList();
		List<List<String>> result = new ArrayList();
		if(s == null) return result;
		digui(s, 0, temp, result);
		return result;
	}
	
	public void digui(String s, int start, List<String> temp, List<List<String>> result){
		if(start == s.length()){
//			�� start == �ַ������ȵ�ʱ��˵����ǰ���ַ����Ѿ��ָĩβ���� temp �����ÿһ���ֶ��ǻ����ַ���
//			��ʱ��Ҫ�½�һ�� list ���������洢 temp �����ֵ�����Ҽ��� result �б���
//			(��Ϊ temp �б��ں���ᷢ���仯)
			List<String> list = new ArrayList(temp);
			result.add(list);
			return;
		}  
		for(int i=start+1;i<=s.length();i++){
			String sub = s.substring(start, i);
//			�����ǰ�Ӵ��ǻ����ַ������򽫵�ǰ�Ӵ����� temp �У����ж�ʣ�µĲ���
			if(is_Palindrome(sub)){
				temp.add(sub);
				digui(s, i, temp, result);
//				�ݹ�������֮������һȥ�����һ��Ԫ��
				temp.remove(temp.size()-1);
			}
		}
	}
	
	
//	�ж�һ���ַ����ǲ��ǻ����ַ����Ĵ��룬����Ŀ Valid_Palindrome ��ͬ
	public boolean is_Palindrome(String temp){
		int start = 0;
		int end = temp.length()-1;
		while(start <= end){
			if(temp.charAt(start) != temp.charAt(end)) 
				return false;
			start++;
			end--;
		}
		return true;
	}

}
