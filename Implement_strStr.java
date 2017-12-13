package top_interview;

public class Implement_strStr {
	public static void main(String args[]){
		String haystack = "hello";
		String needle = "ll";
		Implement_strStr a = new Implement_strStr();
		System.out.println(a.strStr(haystack, needle));
	}
	
//  经典的判断一个字符串是不是另一个字符串的子串的问题
//	本题在leetcode上的难度为easy，因此使用暴力的方法就可以通过，返回子串的第一个字符的位置。
//	暴力的方法O(n^2) 如下：
	
//	public int strStr(String haystack, String needle){
//		if(haystack == null || needle == null) return -1;
//		for(int i=0; i<=haystack.length() - needle.length(); i++){
//			int j=0;
//			for(j=0;j<needle.length();j++){
//				if(needle.charAt(j) != haystack.charAt(i+j)) break;
//			}
//			if(j == needle.length()) return i;
//		}
//		return -1;
//	}

	
//  还有一种方法，并可以借此引出下面的KMP算法
//	public int strStr(String haystack, String needle){
//		if(haystack == null || needle == null) return -1;
//		int i=0;
//		int j=0;
//		while(i<haystack.length() && j<needle.length()){
//			if(haystack.charAt(i) == needle.charAt(j)){
//				i++;
//				j++;
//			}
//			else{
//				i = i-j+1;
//				j=0;
//			}
//		}
//		if(j == needle.length()) return i-j;
//		else return -1;
//	}
	
	
//	接下来是KMP算法 O(n+m)
//	关于KMP算法的详细说明：http://blog.csdn.net/v_july_v/article/details/7041827      http://v.atob.site/kmp-next.html
//	Knuth-Morris-Pratt 字符串查找算法，简称为 “KMP算法”，常用于在一个文本串S内查找一个模式串P 的出现位置
//	KMP算法的核心是计算出next[]数组。
//	next[]数组各值的含义是： 去掉当前字符后，前面的字符串中，前后缀最大公共元素长度
//	计算next[]数组的代码如下：
	public void Get_next(String needle, int next[]){
		next[0] = -1;
		// k是前缀中相同部分的末尾，同时也是相同部分的长度，因为长度等于k-0。
        // j是后缀的末尾，即后缀相同部分的末尾 
		int j=0;
		int k=-1;
		while(j<needle.length()-1){
			// 如果k=-1，说明刚刚失配了，则重新开始计算前缀和后缀相同的长度
            // 如果两个字符相等，则在上次前缀和后缀相同的长度加1就行了
			if(k == -1 || needle.charAt(j) == needle.charAt(k)){
				 k = k+1;
				 j = j+1;
				 next[j] = k;
			}
			else{
			// 否则，前缀长度缩短为next[k]
				k = next[k];
			}
		}
		
	}

//	下面的代码和上面的计算strStr的代码相似，
//	只不过当模式串与文本串不匹配的时候，文本串可以继续向前，不用向后返回；模式串也不需要归0，而是赋予next[j]的值。	
	public int strStr(String haystack, String needle){
		if(haystack == null && needle == null) return -1;
		if(needle.length() == 0) return 0;
		int next[] = new int[needle.length()];
		Get_next(needle, next);
		// 得到next数组
		
		int i=0;
		int j=0;
		// 双指针开始匹配
		while(i<haystack.length() && j<needle.length()){
			// 如果j=-1意味着刚刚失配过，下标+1后，下一轮就可以开始匹配各自的第一个字符了
            // 如果指向的字母相同，则下一轮匹配各自的下一个
			if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
				i++;
				j++;
			}
			else{
			// 如果失配，则将更新j为next[j]
				j = next[j];
			}
		}
		
		if(j == needle.length()) return i-j;
		else return -1;
		
	}
	
	
}
