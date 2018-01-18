package top_interview;

import java.util.ArrayList;
import java.util.List;

public class Word_Break {
	public static void main(String[] args){
		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		Word_Break a = new Word_Break();
		if(a.wordBreak(s, wordDict)) System.out.println("True");
		else System.out.println("False");
	}
	
//	给定一个由若干单词组成的list， 以及一个字符串s
//	判断是否存在一种分割方式，可以将 s 分割成若干部分，且每一部分都在list中
	
//	本题首先可以使用递归的方式解决，逐个判断字符串s的子串，看是否在list中，如果在list中，再进行递归判断，看剩下的部分是不是也在
//	但是这样进行了很多重复的判断，时间复杂度太高
//	public boolean wordBreak(String s, List<String> wordDict){
//		return digui(s, wordDict, 0);
//	}
	
//	public boolean digui(String s, List<String> wordDict, int start){
//		if(start == s.length()) return true;
//		for(int i=start+1;i<=s.length();i++){
//			String temp = s.substring(start, i);
//			if(wordDict.contains(temp)){
//				if(digui(s, wordDict, i)) return true;
//			}
//		}
//		return false;
//	}
	
	
//	因此，本题实际上还是要用动态规划的思想来解决
//	动态规划是一种算法思路，
//	它是利用空间存储历史信息使得未来需要历史信息时不需要重新计算，从而达到降低时间复杂度，是一种用空间换取时间的方法。

//	既然动态规划需要存储历史信息，那我们首先应该确认本题中我们要存储的历史信息
//	我们用 boolean dp[j] 来表示：到字符串 s 的第 i 个字符时，是否可以分割成 wordDict 里面的词
//	if s 的子串 s[0: j] 在 wordDict 里面， 则 dp[j] = true;
//	if i>j, 且 dp[j] = true, 且 s[j: i] 也在 wordDict 里面， 则 dp[i] = true (这样就无需再判断 s[0: i] 是否在 wordDict 中，减少了重复的判断)
	public boolean wordBreak(String s, List<String> wordDict){
		int n = s.length();
		boolean[] dp = new boolean[n+1];
		dp[0] = true;
		for(int i=1;i<=n;i++){
			for(int j=0;j<i;j++){
				if(dp[j] == true && wordDict.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}
}
