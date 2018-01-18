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

//		HashMap�ĵ��������
//		Iterator iter = map.entrySet().iterator();  
//        while (iter.hasNext()) {  
//            Map.Entry entry = (Map.Entry) iter.next();  
//            Object key = entry.getKey();  
//            Object value = entry.getValue();  
//            System.out.println(key + ":" + value);  
//  
//        }  

		
//		Top k ����Ľ�����������ַ�����Ͱ���������С�ѡ�TreeMap��
//		Top K Frequent Elements ����������뵽�ľ���ʹ�� HashMap ����ÿ�����ֳ��ֵĴ�������ͳ�ơ�
//		Ȼ����ʹ�������������Դ������򣬲�ȡǰk�����ֵ
		
//		����ʹ�õ��������С�ѵķ���������
//		��(Heap)ͨ��ָ���Ƕ���ѣ�
//		�������һ��������ȫ�����������ݽṹ�������Ŷ�������Ƥ�����飬��ʹ��������ʵ�ֽ�Ϊ������
//		�ӽ��ļ�ֵ����������С�ڣ����ߴ��ڣ����ĸ��ڵ㣬��ÿ���ڵ��������������һ�������(����ѻ���С����)��
//		���ڵ����Ķѽ������ѻ����ѣ����ڵ���С�Ķѽ�����С�ѻ�С���ѡ���������ʵ�����ȶ��С� 
//		�ɲο�  https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72905

//		����ʹ����һ�ֽϸ߼������ݽṹ��PriorityQueue(���ȶ���)
//		����һ�ֻ������ȼ��ѵļ������ȼ�����
//		������ṩComparator�Ļ������ȶ�����Ԫ��Ĭ�ϰ���Ȼ˳�����У�Ҳ��������Ĭ����С���ڶ���ͷ���ַ������ֵ������У�(��Ĭ����С��)
//		Ҳ���Ը��� Comparator��ָ������ȡ����ʹ�����ֹ��췽����
//		�ɲο�  https://ych0112xzz.github.io/2016/10/27/PriorityQueue/
		
//		���������� �Ƚ����ӿ� Comparator 
//		���ǿ���ͨ�� ��ʵ��Comparator�����½�һ���Ƚ����� ��Ȼ��ͨ���ñȽ��������������
//		ʵ�ֵ� compare �����У� ��� return o1-o2, ������С��(Ĭ��)�� ��� return o2-o1, ��������
		Comparator<Map.Entry<Integer, Integer>> cmp = new Comparator<Map.Entry<Integer, Integer>>(){
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
				return o2.getValue() - o1.getValue();
			}
		};
		
//		Map.Entry��Map������һ���ڲ��ӿڣ��˽ӿ�Ϊ���ͣ�����ΪEntry<K,V>��
//		����ʾMap�е�һ��ʵ�壨һ��key-value�ԣ����ӿ�����getKey(),getValue������
//		����ʹ�� ���� Map.Entry ��Ϊ�˷������ HashMap �е�����
		
//		20 ���ֵֻ��һ����ʼ������ֵ���ɸı䡣
//		cmp �ǱȽ����ıȽϷ���
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
