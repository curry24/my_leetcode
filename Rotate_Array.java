package top_interview;

public class Rotate_Array {
	public static void main(String args[]){
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		Rotate_Array a = new Rotate_Array();
		a.rotate(nums, k);
		for(int i=0;i<7;i++){
			System.out.print(nums[i]+" ");
		}
	}
	
//	Rotate an array of n elements to the right by k steps.
//	旋转数组问题, 其实就是将数组向右移动 k步
//	有若干种方法

	
//	此方法使用了额外的数组 (双数组法)
//	空间复杂度 O(N), 时间复杂度为O(N)
//	public void rotate(int[] nums, int k){
//		int n = nums.length;
//		int[] rotated = new int [n];
//		for(int i=0;i<n;i++){
//			rotated[(i+k)%n] = nums[i];
//		}
//		for(int i=0;i<n;i++){
//			nums[i] = rotated[i];
//		}
//	}

	
//	反转法
//	通过三次反转，我们可以很巧妙的实现旋转数组，即将数组向右移动 k步
//	首先我们将整个数组反转，然后将前k个数字反转，最后再将后面剩下的数字反转，就得到目标数组了。
//	空间复杂度为O(1), 时间复杂度为O(N)
	public void rotate(int[] nums, int k){
		int n = nums.length;
//		k可能大于数组长度，旋转不止一次，所以我们要先对k取余
		k = k%n;
		reverse(nums, 0, n-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, n-1);
		
	}
	
	public void reverse(int[] nums, int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
}
