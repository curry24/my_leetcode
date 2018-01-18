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
	

//	  动态规划的思想
//	  需要遍历一次数组，用一个变量记录遍历过数中的最小值，
//	  然后每次计算当前值和这个最小值之间的差值为当前的利润，
//	  然后每次选较大的利润来更新。
//	  当遍历完成后当前利润即为所求
	 public int maxProfit(int[] prices) {
	        if(prices.length == 0) return 0;
		 	int currentMin = Integer.MAX_VALUE;
	        int bestProfit = 0;
	        
	        for (int i = 0; i < prices.length; i++) {
	            currentMin = Math.min(currentMin, prices[i]);
	            bestProfit = Math.max(bestProfit, prices[i] - currentMin);
	        }
	        
	        return bestProfit;
	    }
	 
	 
}
