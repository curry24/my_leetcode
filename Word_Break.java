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
	
//	����һ�������ɵ�����ɵ�list�� �Լ�һ���ַ���s
//	�ж��Ƿ����һ�ַָʽ�����Խ� s �ָ�����ɲ��֣���ÿһ���ֶ���list��
	
//	�������ȿ���ʹ�õݹ�ķ�ʽ���������ж��ַ���s���Ӵ������Ƿ���list�У������list�У��ٽ��еݹ��жϣ���ʣ�µĲ����ǲ���Ҳ��
//	�������������˺ܶ��ظ����жϣ�ʱ�临�Ӷ�̫��
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
	
	
//	��ˣ�����ʵ���ϻ���Ҫ�ö�̬�滮��˼�������
//	��̬�滮��һ���㷨˼·��
//	�������ÿռ�洢��ʷ��Ϣʹ��δ����Ҫ��ʷ��Ϣʱ����Ҫ���¼��㣬�Ӷ��ﵽ����ʱ�临�Ӷȣ���һ���ÿռ任ȡʱ��ķ�����

//	��Ȼ��̬�滮��Ҫ�洢��ʷ��Ϣ������������Ӧ��ȷ�ϱ���������Ҫ�洢����ʷ��Ϣ
//	������ boolean dp[j] ����ʾ�����ַ��� s �ĵ� i ���ַ�ʱ���Ƿ���Էָ�� wordDict ����Ĵ�
//	if s ���Ӵ� s[0: j] �� wordDict ���棬 �� dp[j] = true;
//	if i>j, �� dp[j] = true, �� s[j: i] Ҳ�� wordDict ���棬 �� dp[i] = true (�������������ж� s[0: i] �Ƿ��� wordDict �У��������ظ����ж�)
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
