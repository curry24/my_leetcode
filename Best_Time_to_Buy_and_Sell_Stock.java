package top_interview;

import java.util.Scanner;

public class Best_Time_to_Buy_and_Sell_Stock {
	
	public static void main(String []args){
		Scanner cin = new Scanner (System.in);
		int n = cin.nextInt();
		int a[] = new int [n];
		if(cin.hasNext()){
			for(int i=0;i<n;i++)
				a[i] = cin.nextInt();
		}
		Best_Time_to_Buy_and_Sell_Stock m = new Best_Time_to_Buy_and_Sell_Stock();
		
		System.out.print(m.maxProfit(a));
		}
	
//	 public int maxProfit(int[] prices) {
//		 
//		 if(prices==null||prices.length==0)
//			 return 0;
//		 
//		 int local=0;
//		 int global=0;
//		 
//		 for(int i=0;i<prices.length-1;i++){
//			 
//			 local = Math.max(local+prices[i+1]-prices[i], 0);
//			 global = Math.max(global, local);
//			 
//		 }
//		 
//		 return global;
//	        
//	    }

	 public int maxProfit(int[] prices) {
	        int currentMin = Integer.MAX_VALUE;
	        int bestProfit = 0;
	        
	        for (int i = 0; i < prices.length; i++) {
	            currentMin = Math.min(currentMin, prices[i]);
	            bestProfit = Math.max(bestProfit, prices[i] - currentMin);
	        }
	        
	        return bestProfit;
	    }
}
