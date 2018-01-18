package top_interview;

public class Valid_Anagram {
	public static void main(String agrs[]){
		String s = "anagram";
		String t = "nagaram";
		Valid_Anagram a = new Valid_Anagram();
		if(a.isAnagram(s, t)) System.out.println("True");
		else System.out.println("False");
		
		
	}
	
//  本题要求来验证变位词	
//	For example,
//	s = "anagram", t = "nagaram", return true.
//	s = "rat", t = "car", return false.
//	You may assume the string contains only lowercase alphabets.
	
//	因为题目说只考虑小写字母，因此可以定义一个大小为26的int数组，用来记录每个字母出现的次数
//	对于一个字符串加，另一个减
//	最后，如果数组里面每个元素都为0，则返回true，否则，返回false
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
	
//	上面的方法还有另一种写法，速度更快
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
