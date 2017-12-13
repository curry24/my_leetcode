package top_interview;

import java.util.Scanner;

public class Longest_Palindromic_Subsequence {
	
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		String s = cin.next();
		Longest_Palindromic_Subsequence a = new Longest_Palindromic_Subsequence();
		System.out.print(a.longestPalindromeSubseq(s));
		
	}
	
	
	public int longestPalindromeSubseq(String s){
		int n = s.length();
		if(n==0) return 0;
		int LPS[][] = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				LPS[i][j] = 0;
		
		for(int i=n-1;i>=0;i--){
			LPS[i][i] = 1;
			for(int j=i+1;j<n;j++){
				if(s.charAt(i)==s.charAt(j))
					LPS[i][j] = LPS[i+1][j-1]+2;
				else LPS[i][j] = Math.max(LPS[i+1][j], LPS[i][j-1]);
			}
		}
		
		return LPS[0][n-1];
	}

}
