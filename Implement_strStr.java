package top_interview;

public class Implement_strStr {
	public static void main(String args[]){
		String haystack = "hello";
		String needle = "ll";
		Implement_strStr a = new Implement_strStr();
		System.out.println(a.strStr(haystack, needle));
	}
	
//  ������ж�һ���ַ����ǲ�����һ���ַ������Ӵ�������
//	������leetcode�ϵ��Ѷ�Ϊeasy�����ʹ�ñ����ķ����Ϳ���ͨ���������Ӵ��ĵ�һ���ַ���λ�á�
//	�����ķ���O(n^2) ���£�
	
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

	
//  ����һ�ַ����������Խ�����������KMP�㷨
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
	
	
//	��������KMP�㷨 O(n+m)
//	����KMP�㷨����ϸ˵����http://blog.csdn.net/v_july_v/article/details/7041827      http://v.atob.site/kmp-next.html
//	Knuth-Morris-Pratt �ַ��������㷨�����Ϊ ��KMP�㷨������������һ���ı���S�ڲ���һ��ģʽ��P �ĳ���λ��
//	KMP�㷨�ĺ����Ǽ����next[]���顣
//	next[]�����ֵ�ĺ����ǣ� ȥ����ǰ�ַ���ǰ����ַ����У�ǰ��׺��󹫹�Ԫ�س���
//	����next[]����Ĵ������£�
	public void Get_next(String needle, int next[]){
		next[0] = -1;
		// k��ǰ׺����ͬ���ֵ�ĩβ��ͬʱҲ����ͬ���ֵĳ��ȣ���Ϊ���ȵ���k-0��
        // j�Ǻ�׺��ĩβ������׺��ͬ���ֵ�ĩβ 
		int j=0;
		int k=-1;
		while(j<needle.length()-1){
			// ���k=-1��˵���ո�ʧ���ˣ������¿�ʼ����ǰ׺�ͺ�׺��ͬ�ĳ���
            // ��������ַ���ȣ������ϴ�ǰ׺�ͺ�׺��ͬ�ĳ��ȼ�1������
			if(k == -1 || needle.charAt(j) == needle.charAt(k)){
				 k = k+1;
				 j = j+1;
				 next[j] = k;
			}
			else{
			// ����ǰ׺��������Ϊnext[k]
				k = next[k];
			}
		}
		
	}

//	����Ĵ��������ļ���strStr�Ĵ������ƣ�
//	ֻ������ģʽ�����ı�����ƥ���ʱ���ı������Լ�����ǰ��������󷵻أ�ģʽ��Ҳ����Ҫ��0�����Ǹ���next[j]��ֵ��	
	public int strStr(String haystack, String needle){
		if(haystack == null && needle == null) return -1;
		if(needle.length() == 0) return 0;
		int next[] = new int[needle.length()];
		Get_next(needle, next);
		// �õ�next����
		
		int i=0;
		int j=0;
		// ˫ָ�뿪ʼƥ��
		while(i<haystack.length() && j<needle.length()){
			// ���j=-1��ζ�Ÿո�ʧ������±�+1����һ�־Ϳ��Կ�ʼƥ����Եĵ�һ���ַ���
            // ���ָ�����ĸ��ͬ������һ��ƥ����Ե���һ��
			if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
				i++;
				j++;
			}
			else{
			// ���ʧ�䣬�򽫸���jΪnext[j]
				j = next[j];
			}
		}
		
		if(j == needle.length()) return i-j;
		else return -1;
		
	}
	
	
}
