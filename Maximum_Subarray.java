package top_interview;

public class Maximum_Subarray {
	public static void main(String args[]){
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		Maximum_Subarray a = new Maximum_Subarray();
		System.out.println(a.maxSubArray(nums));
		
	}
	
//	������Ǿ����������������⣬  https://en.wikipedia.org/wiki/Maximum_subarray_problem
//	��Ҫ�����е�һά�����ҵ�һ�������������У�ʹ�������еĺ����
//	����ʹ�õķ�����DP�����η���
	
//	���Լ�����������:
//	ʹ����DP��˼��
//	public int maxSubArray(int[] nums){
//		if(nums.length == 0) return 0;
//		if(nums.length == 1) return nums[0];
//		int max_sum = nums[0];
//		int result = nums[0];
//		for(int i=1;i<nums.length;i++){
//			int current_sum = max_sum + nums[i];
////			������˵�ǰ���� nums[i] ֮��ȴ�� nums[i] ��С��˵��֮ǰ�������Ѿ�����Ҫ�ˣ�
////			��ˣ��� max_sum = nums[i]
//			if(current_sum < nums[i]) max_sum = nums[i];
////			����max_sum ���� nums[i]
//			else max_sum = current_sum;
//			result = Math.max(result, max_sum);
//		}
//		return result;
//	}
	
	
//	����Ĵ�����������һ�£����Լ�����(��Ȼ��DP��˼��)��
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
	
	
//	���η�����������:
	public int maxSubArray(int[] nums){
		
	}
	
	
}
