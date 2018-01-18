package top_interview;

public class Product_of_Array_Except_Self {
	public static void main(String args[]){
		int[] nums = {1,2,3,4};
		Product_of_Array_Except_Self a = new Product_of_Array_Except_Self();
		int[] output = a.productExceptSelf(nums);
		for(int i=0;i<output.length;i++){
			System.out.print(output[i]+ " ");
		}
		
 	}
	
//	Given an array of n integers where n > 1, nums[], 
//	return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//  Solve it without division and in O(n).
//  For example, given [1,2,3,4], return [24,12,8,6].

//	本题要求计算 除本身之外的数组之积，且不能用除法
//	因此，可以先计算数组中每个元素之前所有元素的乘积，放到一个数组中
//	再计算数组中每个元素之后的所有元素的乘积，放到另一个数组中
//	最后把两个数组对应位置的数乘起来，就是最后的结果
//	public int[] productExceptSelf(int[] nums) {
//        int[] output = new int[nums.length];
//        if(nums.length == 0 ) return output;
//        int[] dp_right = new int[nums.length];
//        int[] dp_left = new int[nums.length];
//        
//        dp_right[0] = nums[0]; 
//        dp_left[nums.length-1] = nums[nums.length-1];
//        int start=1;
//        int end=nums.length-2;
//        while(start<=nums.length-1 && end>=0){
//            dp_right[start] = dp_right[start-1]*nums[start];
//            dp_left[end] = dp_left[end+1]*nums[end];
//            start++;
//            end--;
//        }
//        output[0] = dp_left[1];
//        output[nums.length-1] = dp_right[nums.length-2];
//        for(int i=1;i<nums.length-1;i++){
//            output[i] = dp_right[i-1]*dp_left[i+1];
//        }
//        return output;
//    }
	
//	还可以对上面的方法进行空间上的优化，
//	由于最终的结果都是要乘到结果 output 中，
//	所以我们可以不用单独的数组来保存乘积，而是直接累积到 output 中，
//	我们先从前面遍历一遍，将乘积的累积存入 output 中，
//	然后从后面开始遍历，然后每次不断累积，最终得到正确结果
	public int[] productExceptSelf(int[] nums){
		int n = nums.length;
		int output[] = new int[n];
		if(n == 0) return output;
		int left = 1;
		output[0] = 1;
		for(int i=1;i<nums.length;i++){
			output[i] = left*nums[i-1];
			left = output[i];
		}
		int right = 1;
		for(int i = nums.length-2;i>=0;i--){
			right = right*nums[i+1];
			output[i] = output[i]*right;
		}
		return output;
		
	}

}
