package curry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Three_Sum_Closest {
	public static void main(String []args){
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int nums[] = new int[n];
		if(cin.hasNext()){
			for(int i=0;i<n;i++){
				nums[i] = cin.nextInt();
			}
		}
		int target = cin.nextInt();
		Three_Sum_Closest c = new Three_Sum_Closest();
		System.out.print(c.threeSumClosest(nums,target));
		
	}
	
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
		if(nums == null || nums.length<3)
        	return 0;
        int min = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
//        for(int i=0;i<nums.length-2;i++){
//        	for(int j=i+1;j<nums.length-1;j++){
//        		for(int k=j+1;k<nums.length;k++){
//        			int sum = nums[i]+nums[j]+nums[k];
//        			int temp = Math.abs(sum-target);
//        			if(temp<min){
//        				min = temp;
//        				result = sum;
//        			}
//        		}
//        	}
//        }
        
    	for(int i=0;i<nums.length-2;i++){
				int start = i+1;
				int end = nums.length-1;
				while(start<end){
					int sum = nums[i]+nums[start]+nums[end];
					int temp = Math.abs(sum-target);
					if(temp==0) return sum;
					if(temp<min){
						min = temp;
						result = sum;
					}
					
					if(sum>target) end--;
					else start++;
					
										
				}
			}
		
        return result;
       
    }

}
