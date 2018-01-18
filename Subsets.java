package top_interview;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static void main(String args[]){
		int[] nums = {1,2,3};
		List<List<Integer>> result = new ArrayList();
		Subsets a = new Subsets();
		result = a.subsets(nums);
		System.out.println(result);
	}
	
//	本题还可以使用非递归的方法来求解
//	起始subset集为：[]
//	添加S0后为：[], [S0]
//	添加S1后为：[], [S0], [S1], [S0, S1]
//	添加S2后为：[], [S0], [S1], [S0, S1], [S2], [S0, S2], [S1, S2], [S0, S1, S2]
//	显然规律为添加Si后，新增的subset为克隆现有的所有subset，并在它们后面都加上Si。
//	public List<List<Integer>> subsets(int[] nums){
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		List<Integer> temp = new ArrayList<Integer>();
//		result.add(temp); // add empty set
//		for (int i=0; i<nums.length; i++){
//			int n = result.size();
//			for(int j=0; j<n; j++){
//				// NOTE: must create a new tmp object, and add element to it.
//				temp = new ArrayList<Integer>(result.get(j));
//				temp.add(nums[i]);
//				result.add(new ArrayList<Integer>(temp));
//			}   		
//		}
//		return result;
//	}
	
	
	
//  本题是求给定数组的所有子集的问题，也可以看作是一种排列组合问题
//	这种题首先想到的就是用 递归 求解
//	这种题的方法相似，基本都是：在循环里面进行递归求解
//	然而我竟然没做出来。。。shame on me。。。
//	这种套路的题目还有：Subsets(求子集问题), Permutations, Combination Sum, Palindrome Partitioning(回文分割)

	public List<List<Integer>> subsets(int[] nums){
		List<Integer> temp = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums.length == 0) return result;
		digui(nums, 0, temp, result);
		return result;
	}
	
	public void digui(int[] nums, int start, List<Integer> temp, List<List<Integer>> result){
		List<Integer> list = new ArrayList<Integer>(temp);
		result.add(list);
		for(int i=start;i<nums.length;i++){
			temp.add(nums[i]);
			digui(nums, i+1, temp, result);
			temp.remove(temp.size()-1);
		}
		
	}
}
