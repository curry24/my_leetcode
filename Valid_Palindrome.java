package top_interview;

public class Valid_Palindrome {
	
	public static void main(String args[]){
		String s = "???";
		Valid_Palindrome a = new Valid_Palindrome();
		if(a.isPalindrome(s)) System.out.println("True");
		else System.out.println("No");
	}
	
	
//	�ж�һ���ַ����ǲ�����Ч�Ļ����ַ���
//	ʹ��˫ָ�룬�ֱ������ǰ�ƶ�
//	��Ŀ��Ҫ��Ҫ��ȥ�����֡���ĸ���ַ������Һ��Դ�Сд
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
	
//	�жϵ�ǰ�ַ��ǲ�����ĸ������
	public boolean isAlphaNum(char temp){
		if(temp >= 'a' && temp <= 'z') return true;
		if(temp >= '0' && temp <= '9') return true;
		return false;
	}

}
