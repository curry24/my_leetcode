package top_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Top_K_Frequent_Elements_2 {
	
	public static void main(String args[]){
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		Top_K_Frequent_Elements_2 a = new Top_K_Frequent_Elements_2();
		List<Integer> result = a.topKFrequent(nums, k);
		System.out.println(result);
	}
	
	public List<Integer> topKFrequent(int[] nums, int k){
		List<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++){
			if(!map.containsKey(nums[i])) map.put(nums[i], 1);
			else{
				int value = map.get(nums[i]);
				value++;
				map.put(nums[i], value);
			}
		}
		
//		Top k 问题的解决，有若干种方法，桶排序、最大最小堆、TreeMap等
//		Top K Frequent Elements 这道题首先想到的就是使用 HashMap 来对每个数字出现的次数进行统计。
//		然后再使用其他方法来对次数排序，并取前k个最大值
		
//		这里使用的是桶排序的方法来做的
//		HashMap中键（数据元素）和值（该数据元素出现的频次）是一一对应的，我们在按值进行排序的同时需要记录其对应的元素，鉴于此，我们可以采用“桶排序”的思想。
//		由于我们是按数据元素出现的频次进行排序的，那么“桶”的数量范围是可以确定的——桶的数量小于等于给定数组元素的个数。
//		编号为i的桶用于存放数组中出现频次为i的元素——即编号为i的桶存放“映射表”中“值”等于i的“键”。
//		排序完成后，编号大的桶中元素出现的频次高，因此，我们“逆序”(先取桶编号大的桶的元素)获取桶中数据，
//		直到获取数据的个数等于k，我们将当前桶的元素取尽（同一个桶中元素出现的频次相等）,然后停止取数据，完成！
	
		List<Integer>[] bucket = new ArrayList[nums.length+1];	//定义足够数量的桶 
		for(int i: map.keySet()){
			int count =	map.get(i);
			if(bucket[count] == null) bucket[count] = new ArrayList<Integer>();
			//把出现频次相同的元素“扔”到序号等于频次的桶中
			bucket[count].add(i);
		}
		//“逆序”取数据  
		for(int i=bucket.length-1;i>0;i--){
			if(bucket[i] != null && result.size()<k){
				result.addAll(bucket[i]);
			}
		}
		
		return result;
 
		
	}

}
