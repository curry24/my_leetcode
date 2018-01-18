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
	

//	  ��̬�滮��˼��
//	  ��Ҫ����һ�����飬��һ��������¼���������е���Сֵ��
//	  Ȼ��ÿ�μ��㵱ǰֵ�������Сֵ֮��Ĳ�ֵΪ��ǰ������
//	  Ȼ��ÿ��ѡ�ϴ�����������¡�
//	  ��������ɺ�ǰ����Ϊ����
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
