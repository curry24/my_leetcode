package top_interview;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {
	public static void main(String agrs[]){
		int[] nums = {1,2,3,4,5,6,4};
		Contains_Duplicate a = new Contains_Duplicate();
		if(a.containsDuplicate(nums)) System.out.println("True");
		else System.out.println("False");
	}
	
//	Given an array of integers, find if the array contains any duplicates. 
//	Your function should return true if any value appears at least twice in the array, 
//	and it should return false if every element is distinct.
//	使用HashSet就可以解决
	public boolean containsDuplicate(int[] nums){
		if(nums.length == 0) return false;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<nums.length;i++){
			if(!set.contains(nums[i])) set.add(nums[i]);
			else return true;
		}
		return false;
	}

}
