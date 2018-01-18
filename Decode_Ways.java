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
	
//	����Ҫ��������뷽ʽ�ĸ�������û��Ҫ������Щ���뷽ʽ
//	���ȣ�������Բ���  �ַ����Ļ��ķָ�  �еķ�����ʹ��ѭ���ӵݹ�ķ�ʽ�����
//	�����ķ������������Եõ������������Եõ�����Ľ��뷽ʽ�����ǻᳬʱ��
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
	
	
//	��ˣ����⻹��Ҫʹ�ö�̬�滮��˼�������н�����ÿռ�����ȡʱ��
//	����һ������ dp[i], ��ʾ���ǣ����Ӵ��ĳ���Ϊ i ʱ�����뷽ʽ�ĸ���
//	���� s.length() == n, �򷵻� dp[n] ��ֵ���ɡ�
//	���������һ�����ƵĹ�ϵ
//	����ַ����ĵ� i λ����0�Ļ���˵���������ڵ� i-1 λ�Ľ��뷽���ϼ������롣
//	����ַ����ĵ� i-1 λ�͵� i λ�����һ�� 10 �� 26 �����֣�˵���������ڵ�i-2λ�Ľ��뷽���ϼ������롣
//	���ԣ�������ϵ�һ���������� dp[i] = dp[i] + dp[i-1]��
//	������ϵڶ������� ���� dp[i] = dp[i] + dp[i-2]
//	����� Climbing_Stairs �����Ŀ˼·���ƣ����Խ��вο���
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
