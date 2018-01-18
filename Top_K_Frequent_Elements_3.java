package top_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Top_K_Frequent_Elements_3 {
	public static void main(String args[]){
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		Top_K_Frequent_Elements a = new Top_K_Frequent_Elements();
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
		
//		这里使用的是TreeMap的方法来做的
//		TreeMap的介绍   https://www.cnblogs.com/skywang12345/p/3310928.html
//		TreeMap 是一个有序的key-value集合，它是通过红黑树实现的。
//		TreeMap 继承于AbstractMap，所以它是一个Map，即一个key-value集合。
//		TreeMap 实现了NavigableMap接口，意味着它支持一系列的导航方法。比如返回有序的key集合。
//		TreeMap 实现了Cloneable接口，意味着它能被克隆。
//		TreeMap 实现了java.io.Serializable接口，意味着它支持序列化。
//		TreeMap基于红黑树（Red-Black tree）实现。该映射根据其键的自然顺序进行排序，或者根据创建映射时提供的 Comparator 进行排序，具体取决于使用的构造方法。
//		R-B Tree，全称是Red-Black Tree，又称为“红黑树”，它一种特殊的二叉查找树。
//		红黑树的每个节点上都有存储位表示节点的颜色，可以是红(Red)或黑(Black)。
//		红黑树的介绍   http://www.cnblogs.com/skywang12345/p/3245399.html
		
//		TreeMap 的  key 是每个数字出现的次数，value是出现了该次数的有哪些数字
		TreeMap<Integer, List<Integer>> treemap = new TreeMap();
		for(int i: map.keySet()){
			int count = map.get(i);
			if(!treemap.containsKey(count)){
				treemap.put(count, new LinkedList<Integer>());
			}
			treemap.get(count).add(i);
		}
		
//		因为TreeMap中默认按自然顺序排序，即按照key的值，由小到大排序
//		因此要得到出现次数最多的k个数，要逆序输出
		while(result.size()<k){
			Map.Entry<Integer, List<Integer>> entry = treemap.pollLastEntry();
			result.addAll(entry.getValue());
		}	
		return result;	
	}
}
