package top_interview;

public class Reverse_Bits {
	public static void main(String args[]){
		int n = 43261596;
		Reverse_Bits a = new Reverse_Bits();
		System.out.println(a.reverseBits(n));
	}
//	知识点：java的位运算符
	public int reverseBits(int n){
		int result = 0;
        for (int i = 0; i < 32; i++, n>>=1) {
//   将右移一位后的数字与 1 进行 & 运算，可以得到最后一个数字的值(1或0)
        	result += n & 1; 
            if (i < 31) // 最后一个数字不需要进行左移
                result <<= 1;
        }
        return result;
		
	}
	

}
