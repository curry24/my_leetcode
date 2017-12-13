package top_interview;

public class Reverse_String {
	public static void main(String args[]){
		String s = "hello";
		Reverse_String a = new Reverse_String();
		System.out.println(a.reverseString(s));
	}
	
//	public String reverseString(String s){
//		int length = s.length();
//		if(length==0 || s==null) return "";
//		char reverse_s[] = new char[length];
//		for(int i=0,j=length-1;i<length;i++,j--){
//			reverse_s[i] = s.charAt(j);
//		}
//		String result = new String(reverse_s);
//		return result;
//	}
	
	public String reverseString(String s){
		int length = s.length();
		if(length==0 || s==null) return "";
		char reverse_s[] = s.toCharArray();
		char temp;
		for(int i=0;i<length/2;i++){
			temp = reverse_s[i];
			reverse_s[i] = reverse_s[length-1-i];
			reverse_s[length-1-i] = temp;
		}
		
		return new String(reverse_s);
	}
	

}
