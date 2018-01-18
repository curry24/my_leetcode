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
	
//	���⻹����ʹ�÷ǵݹ�ķ��������
//	��ʼsubset��Ϊ��[]
//	���S0��Ϊ��[], [S0]
//	���S1��Ϊ��[], [S0], [S1], [S0, S1]
//	���S2��Ϊ��[], [S0], [S1], [S0, S1], [S2], [S0, S2], [S1, S2], [S0, S1, S2]
//	��Ȼ����Ϊ���Si��������subsetΪ��¡���е�����subset���������Ǻ��涼����Si��
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
	
	
	
//  ���������������������Ӽ������⣬Ҳ���Կ�����һ�������������
//	�����������뵽�ľ����� �ݹ� ���
//	������ķ������ƣ��������ǣ���ѭ��������еݹ����
//	Ȼ���Ҿ�Ȼû������������shame on me������
//	������·����Ŀ���У�Subsets(���Ӽ�����), Permutations, Combination Sum, Palindrome Partitioning(���ķָ�)

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
