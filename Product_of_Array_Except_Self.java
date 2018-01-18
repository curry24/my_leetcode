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

//	����Ҫ����� ������֮�������֮�����Ҳ����ó���
//	��ˣ������ȼ���������ÿ��Ԫ��֮ǰ����Ԫ�صĳ˻����ŵ�һ��������
//	�ټ���������ÿ��Ԫ��֮�������Ԫ�صĳ˻����ŵ���һ��������
//	�������������Ӧλ�õ������������������Ľ��
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
	
//	�����Զ�����ķ������пռ��ϵ��Ż���
//	�������յĽ������Ҫ�˵���� output �У�
//	�������ǿ��Բ��õ���������������˻�������ֱ���ۻ��� output �У�
//	�����ȴ�ǰ�����һ�飬���˻����ۻ����� output �У�
//	Ȼ��Ӻ��濪ʼ������Ȼ��ÿ�β����ۻ������յõ���ȷ���
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
