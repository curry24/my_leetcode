package top_interview;

public class Jump_Game {
	public static void main(String args[]){
		int[] nums = {3,2,1,0,4};
		Jump_Game a = new Jump_Game();
		System.out.println(a.canJump(nums));
	}
	
//  首先可以用  dp 来做，是一个  一维  dp 问题
//	public boolean canJump(int[] nums){
//		if(nums == null || nums.length == 0) return false;
//		int[] dp = new int[nums.length];
////		dp[i] 表示的是从 0 走到 i 时，剩余的最大的步数
////      dp[i] = 0  (i=0)
////		dp[i] = Max( dp[i-1], nums[i-1]) - 1  (i>0)
////		如果  dp[i] < 0, 则无法走到当前位置
////		(感觉用 dp 做，并不太好理解)
//		dp[0] = 0;
//		for(int i=1;i<nums.length;i++){
//			dp[i] = Math.max(dp[i-1], nums[i-1]) - 1;
//			if(dp[i] < 0)  return false;
//		}
//		return dp[nums.length-1] >= 0;
//	}
	
	
//	可以使用贪心的方法来做
//	其实也是 dp 的思想
//	设置一个 MaxIndex 值，用来表示当前所能到达的最大的索引的位置
//	然后遍历数组中的值，并且不断更新 MaxIndex 的值
//	MaxIndex = Max( MaxIndex, i+nums[i])
//	并且在遍历的过程中做出判断， 如果当前位置 i 大于最大索引位置 MaxIndex，则说明都到不了i位置，更不会到达最后一个位置，则break
//	且这种情况下 nums.length-1 > i > MaxIndex , 所以返回 false
//	还有，如果 MaxIndex >= nums.length-1, 则说明肯定可以到达最后一个位置，则break, 且返回true
	public boolean canJump(int[] nums){
		if(nums == null || nums.length == 0) return false;
		int MaxIndex = 0;
		for(int i=0;i<nums.length;i++){
			if(i > MaxIndex || MaxIndex >= nums.length-1) break;
			MaxIndex = Math.max(MaxIndex, i+nums[i]);
		}
		return MaxIndex >= nums.length-1;
	}

}
