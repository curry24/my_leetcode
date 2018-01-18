package top_interview;

public class Valid_Palindrome {
	
	public static void main(String args[]){
		String s = "???";
		Valid_Palindrome a = new Valid_Palindrome();
		if(a.isPalindrome(s)) System.out.println("True");
		else System.out.println("No");
	}
	
	
//	判断一个字符串是不是有效的回文字符串
//	使用双指针，分别向后向前移动
//	题目中要求要除去非数字、字母的字符，并且忽略大小写
	public boolean isPalindrome(String s){
		if(s == null) return true;
		s = s.toLowerCase();
		int start = 0;
		int end = s.length()-1;
		while(start <= end){
			while(start < end && !isAlphaNum(s.charAt(start))) start++;
			while(start < end && !isAlphaNum(s.charAt(end))) end--;
			if(s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
	
//	判断当前字符是不是字母或数字
	public boolean isAlphaNum(char temp){
		if(temp >= 'a' && temp <= 'z') return true;
		if(temp >= '0' && temp <= '9') return true;
		return false;
	}

}
