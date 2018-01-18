package top_interview;

public class Move_Zeroes {
	public static void main(String agrs[]){
//		int[] nums = {0, 1, 0, 3, 12};
		int[] nums = {1, 0, 3, 0, 12};
		Move_Zeroes a = new Move_Zeroes();
		a.moveZeroes(nums);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]+" ");
		}
	}

//	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//  For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]
	
//	本题实际上就是将所有的非0数向前尽可能的压缩，最后把没压缩的那部分全置0就行了。
//	比如103040，先压缩成134，剩余的3为全置为0。
//	过程中需要一个指针记录压缩到的位置。
	public void moveZeroes(int[] nums){
		int n = nums.length;
        int index = 0;
        for(int i=0;i<n;i++){
          if(nums[i] != 0){
              nums[index] = nums[i];
              index++;
          }
        }
        for(;index<nums.length;index++){
            nums[index] = 0;
        }
	}
}
