package top_interview;


import java.util.Scanner;

public class Count_and_Say {
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		Count_and_Say a = new Count_and_Say();
		System.out.println(a.countAndSay(n));
	}
	
	
//	��Ŀ˵�Ĳ��Ǻ����
//	ʹ�õݹ���Խ��н��
	public String countAndSay(int n){
		if(n == 1) return "1";
		String m = countAndSay(n-1) + "*";
//		���ַ���ĩβ��һ�� * ����֤���Ա������ַ��������һ���ַ�
		return count(m);
	}
	
	public String count(String m){
		char[] shuzu = m.toCharArray();
		String s = "";
		for(int i=0;i<m.length()-1;i++){
			int num = 1;
			while(shuzu[i] == shuzu[i+1]){
				num++;
				i++;
			}
			s = s + num + shuzu[i];	
//			����ʹ����String�еģ�ʹ�üӺ� "+" ��ƴ���ַ���
//			��������һ��֪ʶ�㣬 Java���ַ�����ƴ�ӣ���������档
		}
		return s;
	}
	
	
//	Java ���ַ���ƴ�ӵ����ַ�����
//	1.�Ӻţ�     2.concat������	  3.StringBuilder(�� StringBuffer)�� append ����
	
//	1.  "+" �Ӻŷ����У�ʵ������ʹ�� StringBuilder �� append ������ʵ�֣�������ͨ�� toString ������ת���� String �ַ�����
//		str = new StringBuilder(str).append("haha").toString();
//		���봿���ʹ��StringBuilder��append�����ǲ�ͬ�ģ� 
//		�� ÿ��ѭ�����ᴴ��һ��StringBuilder���� 
//		�� ÿ��ִ����϶������toString��������ת��Ϊ�ַ��� 
//		���ԣ��ͺķ��˸����ʱ�䡣(����)
	
//	2.  concat ���� �� 	String str = "haha";  str.concat("hehe"); 
//		������һ������Ŀ�������Ȼ���ڴ����Ǵ�����ԭ���Բ������ٶȷǳ��죬
//		���ǣ�����return��䴴��һ����String����Ҳ����ÿ��concat�������ᴴ��һ���µ�String����
//		��Ҳ������concat�����ٶȵ�ԭ�� (����)
	
//	3.	append ���� 
//		StringBuilder stringBuilder = new StringBuilder("haha");
//		stringBuilder.append("hehe");	
//		String str = stringBuilder.toString();
//		����append�����������ַ�����Ĵ����ӳ��������ȣ�
//		��Щ���ǻ��������ݴ������������ڲ�û�����ɶ���
//		��� toString() ����һ�� String ���� (���)
}
