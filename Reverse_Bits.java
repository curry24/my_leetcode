package top_interview;

public class Reverse_Bits {
	public static void main(String args[]){
		int n = 43261596;
		Reverse_Bits a = new Reverse_Bits();
		System.out.println(a.reverseBits(n));
	}
//	֪ʶ�㣺java��λ�����
	public int reverseBits(int n){
		int result = 0;
        for (int i = 0; i < 32; i++, n>>=1) {
//   ������һλ��������� 1 ���� & ���㣬���Եõ����һ�����ֵ�ֵ(1��0)
        	result += n & 1; 
            if (i < 31) // ���һ�����ֲ���Ҫ��������
                result <<= 1;
        }
        return result;
		
	}
	

}
