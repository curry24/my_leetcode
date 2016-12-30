package curry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Three_Sum {
	public static void main(String []args){
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int nums[] = new int[n];
		if(cin.hasNext()){
			for(int i=0;i<n;i++){
				nums[i] = cin.nextInt();
			}
		}
		
		Three_Sum c = new Three_Sum();
		System.out.print(c.threeSum(nums));
		
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		if(nums==null||nums.length<3)
			return result;
		for(int i=0;i<nums.length-2;i++){
			if(i==0 ||nums[i]>nums[i-1]){   //避免起始点的数值重复
				int start = i+1;
				int end = nums.length-1;
				while(start<end){
					int sum = nums[i]+nums[start]+nums[end];
					if(sum==0){
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[start]);
						temp.add(nums[end]);
						result.add(temp);
						
						start++;
						end--;
						//避免正向移动的后一位与前一位数值重复
						while(start<end && nums[start]==nums[start-1]) start++;
						//避免反向移动的前一位与后一位数值重复
						while(start<end && nums[end]==nums[end+1]) end--;
						
					}
					else if(sum<0) start++;
					else end--;
										
				}
			}
		}
		
		return result;
		
		
    }
}
