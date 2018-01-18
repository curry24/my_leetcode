package top_interview;

public class Decode_Ways {
	
	public static void main(String args[]){
		String s = "273020";
		Decode_Ways a = new Decode_Ways();
		System.out.println(a.numDecodings(s));
	}
	
//	 A message containing letters from A-Z is being encoded to numbers using the following mapping:
//  'A' -> 1
//  'B' -> 2
//  ...
//  'Z' -> 26
//   Given an encoded message containing digits, determine the total number of ways to decode it.
//   For example,
//   Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//   The number of ways decoding "12" is 2.
	
//	本题要求给出解码方式的个数，并没有要求都有哪些解码方式
//	首先，本题可以参照  字符串的回文分割  中的方法，使用循环加递归的方式来求解
//	这样的方法，不仅可以得到个数，还可以得到具体的解码方式，但是会超时。
//	int num = 0;
//	public int numDecodings(String s){
//		if(s == null || s.length() == 0) return 0;
//		digui(s, 0);
//		return num;
//	}
	
//	public void digui(String s, int start){
//		if(start == s.length()){
//			num++;
//		}
//		
//		for(int i = start+1; i <= s.length(); i++){
//			String sub = s.substring(start, i);
//			int temp = Integer.parseInt(sub);
//			if(temp>=1 && temp<=26){
//				digui(s, i);
//			}
//		}
//		
//	}
	
	
//	因此，本题还是要使用动态规划的思想来进行解决，用空间来换取时间
//	建立一个数组 dp[i], 表示的是，当子串的长度为 i 时，解码方式的个数
//	假设 s.length() == n, 则返回 dp[n] 的值即可。
//	这里存在着一个递推的关系
//	如果字符串的第 i 位不是0的话，说明我们是在第 i-1 位的解码方法上继续解码。
//	如果字符串的第 i-1 位和第 i 位能组成一个 10 到 26 的数字，说明我们是在第i-2位的解码方法上继续解码。
//	所以，如果符合第一个条件，则 dp[i] = dp[i] + dp[i-1]，
//	如果符合第二个条件 ，则 dp[i] = dp[i] + dp[i-2]
//	本题和 Climbing_Stairs 这道题目思路相似，可以进行参考。
	public int numDecodings(String s){
		if(s == null || s.length() == 0) return 0;
		int n = s.length();
		int[] dp = new int[n+1];
		dp[0]=1;
		if(s.charAt(0) == '0'){
			dp[1] = 0;
			return 0;
		}
		else dp[1] = 1;
		for(int i=2;i<=n;i++){
			int first = Integer.valueOf(s.substring(i-1, i));
			int second = Integer.valueOf(s.substring(i-2, i));
			if(first != 0) dp[i] += dp[i-1];
			if(second >=10 && second <=26) dp[i] += dp[i-2];
		}
		return dp[n];
		
	}
}
