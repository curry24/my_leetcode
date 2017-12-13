package top_interview;

import java.util.Arrays;
import java.util.Scanner;

public class Coin_change {
	
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int nums[] = new int [n];
		if(cin.hasNext()){
			for(int i=0;i<n;i++)
				nums[i] = cin.nextInt();
		}
		int target = cin.nextInt();
		
		Coin_change m = new Coin_change();
		System.out.print(m.coinChange(nums, target));
	}
	
	public int coinChange(int[] coins, int amount) {

		int dp[] = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}

			}
		}
        
        for(int i=0;i<=amount;i++) System.out.print(dp[i]);
        
        return dp[amount]>amount ? -1:dp[amount];
    }
	
	

}
