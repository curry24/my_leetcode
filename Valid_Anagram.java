package top_interview;

public class Valid_Anagram {
	public static void main(String agrs[]){
		String s = "anagram";
		String t = "nagaram";
		Valid_Anagram a = new Valid_Anagram();
		if(a.isAnagram(s, t)) System.out.println("True");
		else System.out.println("False");
		
		
	}
	
//  ����Ҫ������֤��λ��	
//	For example,
//	s = "anagram", t = "nagaram", return true.
//	s = "rat", t = "car", return false.
//	You may assume the string contains only lowercase alphabets.
	
//	��Ϊ��Ŀ˵ֻ����Сд��ĸ����˿��Զ���һ����СΪ26��int���飬������¼ÿ����ĸ���ֵĴ���
//	����һ���ַ����ӣ���һ����
//	��������������ÿ��Ԫ�ض�Ϊ0���򷵻�true�����򣬷���false
//	public boolean isAnagram(String s, String t){
//		if(s.length() != t.length()) return false;
//		int alphabet[] = new int[26];
//		for(int i=0;i<s.length();i++){
//			alphabet[s.charAt(i)-'a']++;
//			alphabet[t.charAt(i)-'a']--;
//		}
//	
//		for(int i=0;i<alphabet.length;i++){
//			if(alphabet[i] != 0) return false;
//		}
//		return true;
//	}
	
//	����ķ���������һ��д�����ٶȸ���
	public boolean isAnagram(String s, String t){
		if(s.length() != t.length()) return false;
		int alphabet[] = new int [26];
		for(Character m : s.toCharArray()){
			alphabet[m-'a']++;
		}
		for(Character n : t.toCharArray()){
			alphabet[n-'a']--;
		}
		for(int i : alphabet){
			if(i != 0) return false;
		}
		return true;
	}

}
