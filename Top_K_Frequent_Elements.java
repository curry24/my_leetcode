package top_interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
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

//		HashMap的迭代与输出
//		Iterator iter = map.entrySet().iterator();  
//        while (iter.hasNext()) {  
//            Map.Entry entry = (Map.Entry) iter.next();  
//            Object key = entry.getKey();  
//            Object value = entry.getValue();  
//            System.out.println(key + ":" + value);  
//  
//        }  

		
//		Top k 问题的解决，有若干种方法，桶排序、最大最小堆、TreeMap等
//		Top K Frequent Elements 这道题首先想到的就是使用 HashMap 来对每个数字出现的次数进行统计。
//		然后再使用其他方法来对次数排序，并取前k个最大值
		
//		这里使用的是最大最小堆的方法来做的
//		堆(Heap)通常指的是二叉堆，
//		二叉堆是一个近似完全二叉树的数据结构，即披着二叉树羊皮的数组，故使用数组来实现较为便利。
//		子结点的键值或索引总是小于（或者大于）它的父节点，且每个节点的左右子树又是一个二叉堆(大根堆或者小根堆)。
//		根节点最大的堆叫做最大堆或大根堆，根节点最小的堆叫做最小堆或小根堆。常被用作实现优先队列。 
//		可参考  https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72905

//		这里使用了一种较高级的数据结构，PriorityQueue(优先队列)
//		它是一种基于优先级堆的极大优先级队列
//		如果不提供Comparator的话，优先队列中元素默认按自然顺序排列，也就是数字默认是小的在队列头，字符串则按字典序排列，(即默认最小堆)
//		也可以根据 Comparator来指定，这取决于使用哪种构造方法。
//		可参考  https://ych0112xzz.github.io/2016/10/27/PriorityQueue/
		
//		接下来介绍 比较器接口 Comparator 
//		我们可以通过 “实现Comparator类来新建一个比较器” ，然后通过该比较器对类进行排序
//		实现的 compare 方法中， 如果 return o1-o2, 则是最小堆(默认)； 如果 return o2-o1, 则是最大堆
		Comparator<Map.Entry<Integer, Integer>> cmp = new Comparator<Map.Entry<Integer, Integer>>(){
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
				return o2.getValue() - o1.getValue();
			}
		};
		
//		Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。
//		它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。
//		这里使用 泛型 Map.Entry 是为了方便遍历 HashMap 中的内容
		
//		20 这个值只是一个初始的容量值，可改变。
//		cmp 是比较器的比较方法
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(20, cmp);

		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			maxHeap.offer(entry);
		}
		
		while(result.size()<k){
			Map.Entry<Integer, Integer> out = maxHeap.poll();
			result.add(out.getKey());
		}
			
		return result;
	  
		
	}
}
