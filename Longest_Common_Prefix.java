package top_interview;

public class Longest_Common_Prefix {
	public static void main(String args[]){
		String strs[] = new String[3];
		strs[0] = "aaabb";
		strs[1] = "aabb";
		strs[2] = "aacc";
		Longest_Common_Prefix a = new Longest_Common_Prefix();
		System.out.println(a.longestCommonPrefix(strs));
	}

	public String longestCommonPrefix(String[] strs){
		if(strs.length == 0) return "";
		int minlength = Integer.MAX_VALUE;
		for(int i=0;i<strs.length;i++){
			if(strs[i]==null) return "";
			int length = strs[i].length();
			if(length==0) return "";
			if(length < minlength) minlength = length;	
		}

		int i=0;
		for(;i<minlength;i++){
			int j=1;
			for(;j<strs.length;j++){
				if(strs[0].charAt(i)!=strs[j].charAt(i)) break;
			}		
			if(j!=strs.length) break;		
		}
		return strs[0].substring(0, i); 
	}
}
