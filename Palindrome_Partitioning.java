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
	
//	本题的要求是，给定一个字符串，需要将字符串分割成若干回文子串，需要给出所有的可能的情况
//	(回文分割)
//	因此，本题需要用递归(DFS)来进行解决
//	实际上，本题与 Word_Break 题目很像，都是在循环内部进行判断，若满足某个条件，则进行递归遍历
	public List<List<String>> partition(String s){
		List<String> temp = new ArrayList();
		List<List<String>> result = new ArrayList();
		if(s == null) return result;
		digui(s, 0, temp, result);
		return result;
	}
	
	public void digui(String s, int start, List<String> temp, List<List<String>> result){
		if(start == s.length()){
//			当 start == 字符串长度的时候，说明当前的字符串已经分割到末尾，且 temp 里面的每一部分都是回文字符串
//			此时需要新建一个 list 变量用来存储 temp 里面的值，并且加入 result 列表中
//			(因为 temp 列表在后面会发生变化)
			List<String> list = new ArrayList(temp);
			result.add(list);
			return;
		}  
		for(int i=start+1;i<=s.length();i++){
			String sub = s.substring(start, i);
//			如果当前子串是回文字符串，则将当前子串加入 temp 中，并判断剩下的部分
			if(is_Palindrome(sub)){
				temp.add(sub);
				digui(s, i, temp, result);
//				递归搜索完之后，再逐一去掉最后一个元素
				temp.remove(temp.size()-1);
			}
		}
	}
	
	
//	判断一个字符串是不是回文字符串的代码，与题目 Valid_Palindrome 相同
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
