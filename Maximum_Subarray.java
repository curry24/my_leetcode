package top_interview;

public class Maximum_Subarray {
	public static void main(String args[]){
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		Maximum_Subarray a = new Maximum_Subarray();
		System.out.println(a.maxSubArray(nums));
		
	}
	
//	这道题是经典的最大子数列问题，  https://en.wikipedia.org/wiki/Maximum_subarray_problem
//	需要在数列的一维方向找到一个连续的子数列，使该子数列的和最大。
//	经常使用的方法有DP、分治法。
	
//	我自己的做法如下:
//	使用了DP的思想
//	public int maxSubArray(int[] nums){
//		if(nums.length == 0) return 0;
//		if(nums.length == 1) return nums[0];
//		int max_sum = nums[0];
//		int result = nums[0];
//		for(int i=1;i<nums.length;i++){
//			int current_sum = max_sum + nums[i];
////			如果加了当前数字 nums[i] 之后，却比 nums[i] 还小，说明之前的数字已经不需要了，
////			因此，令 max_sum = nums[i]
//			if(current_sum < nums[i]) max_sum = nums[i];
////			否则，max_sum 加上 nums[i]
//			else max_sum = current_sum;
//			result = Math.max(result, max_sum);
//		}
//		return result;
//	}
	
	
//	上面的代码重新整理一下，可以简化如下(依然是DP的思想)：
//	public int maxSubArray(int[] nums){
//		if(nums.length == 0) return 0;
//		if(nums.length == 1) return nums[0];
//		int new_sum = nums[0];
//		int result_max = nums[0];
//		
//		for(int i=1;i<nums.length;i++){
//			new_sum = Math.max(new_sum + nums[i], nums[i]);
//			result_max = Math.max(result_max, new_sum);
//		}
//		return result_max;
//	}
	
	
//	分治法的做法如下:
	public int maxSubArray(int[] nums){
		
	}
	
	
}
