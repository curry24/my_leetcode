package top_interview;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static void main(String args[]){
		int[] nums = {1,2,3};
		Permutations a = new Permutations();
		System.out.println(a.permute(nums));
	}
	
//	Given a collection of distinct numbers, return all possible permutations.
//	For example,
//	[1,2,3] have the following permutations:
//	[
//	  [1,2,3],
//	  [1,3,2],
//	  [2,1,3],
//	  [2,3,1],
//	  [3,1,2],
//	  [3,2,1]
//	]
	
//	�������һ�����ظ����������飬Ҫ��õ���������ȫ����
//	���������Ե�����������⣬ȫ���еĸ���Ϊ n!
//	����Ľⷨ��  Palindrome_Partitioning(�ַ����Ļ��ķָ�)��Subsets(������������Ӽ�)��Combination Sum ����Ŀ��˼·�ͷ�������ͬ
//	����ʹ�� ѭ���ӵݹ� �ķ�ʽ�����н��

	public List<List<Integer>> permute(int[] nums){
		 List<Integer> temp = new ArrayList<Integer>();
	     List<List<Integer>> result = new ArrayList<List<Integer>>();
	     if(nums.length == 0) return result;
	     digui(nums, temp, result);
	     return result;	
	}
	
	public void digui(int[] nums, List<Integer> temp, List<List<Integer>> result){
	     if(temp.size() == nums.length){
	    	 result.add(new ArrayList<Integer>(temp));
	         return;
	     }
	        
	     for(int i=0;i<nums.length;i++){
	         if(!temp.contains(nums[i])){
	        	 temp.add(nums[i]);
		         digui(nums, temp, result);
		         temp.remove(temp.size()-1);
	         } 
	         
	     }
	}
}
