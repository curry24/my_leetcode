package top_interview;

import java.util.HashMap;
import java.util.Stack;

public class Valid_Parentheses {
	
	public static void main(String []args){
		
//		String test = ")";
		String test = "({[]})";
		Valid_Parentheses a = new Valid_Parentheses();
		if (a.isValid(test)){
			System.out.println("yes");
		}
		else System.out.println("no");
	}
//	经典的使用栈的数据结构来解决括号匹配的问题。
//	java 中 stack 是  vector 的一个子类，它是一个标准的后进先出的栈
	public boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for(char c:s.toCharArray()){
			if(c == '(') stack.push(')');
			else if(c == '[') stack.push(']');
			else if(c == '{') stack.push('}');
			else if(stack.isEmpty() || c != stack.pop()) return false;
		}
		return stack.isEmpty();
		
	}
	
//	public boolean isValid(String s){
//		Stack<Character> stack = new Stack<Character>();
//		HashMap<Character, Character> map = new HashMap<Character, Character>(); 
//		map.put('(', ')');
//		map.put('[', ']');
//		map.put('{', '}');
//		for(int i=0;i<s.length();i++){
//			char c = s.charAt(i);
//			if(map.containsKey(c)) stack.push(c);
//			else if(map.containsValue(c)){
//				if (!stack.empty() && map.get(stack.peek()) == c) stack.pop();
//				else return false;
//			} 
//		}
//		return stack.isEmpty();
//		
//		
//	}

}
