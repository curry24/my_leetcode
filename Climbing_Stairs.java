package top_interview;

import java.util.Scanner;

public class Climbing_Stairs {
	
		public static void main(String []args){
			
			Scanner cin = new Scanner (System.in);
			int n = cin.nextInt();
		
			Climbing_Stairs m = new Climbing_Stairs();
		
			System.out.print(m.climbStairs(n));
		}
	
	
	 	public int climbStairs(int n) {
	 		
	 		if(n<=1) return 1;
	 		
	 		int dp[] = new int[n];
	 		dp[0] = 1;
	 		dp[1] = 2;
	 		
	 		for(int i=2;i<n;i++){
	 			
	 			dp[i] = dp[i-1]+dp[i-2];
	 		}
	 		
	 		return dp[n-1];
	 		
	    }
	 	
//		public int climbStairs(int n) {
//		    if (n == 0)
//		        return 1;
//		    else if (n < 0)
//		        return 0;
//		    return climbStairs(n - 1) + climbStairs(n - 2);
//		}

}
