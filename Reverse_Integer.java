package top_interview;

public class Reverse_Integer {
	public static void main(String args[]){
		int x = 1000000003;
		Reverse_Integer a = new Reverse_Integer();
		System.out.println(a.reverse(x));
		
	}
	
	 public int reverse(int x) {
		 int new_x = 0;
		 int temp;
	     while(x!=0){
	       temp = 10*new_x + x % 10;
	       System.out.println("temp:" + temp);
	       x = x/10;
//	       如果超过32位整数的最大值，则发生溢出，则输出0，例如3000000001
//	    32位整数的取值范围为：-2^31~2^31-1 即 -2147483648到2147483647
	       if(temp /10 != new_x){
	    	   new_x = 0;
	    	   break;
	       }
	       new_x = temp;
	     }
	     return new_x; 
	        
	}

}
