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
		
//		Top k ����Ľ�����������ַ�����Ͱ���������С�ѡ�TreeMap��
//		Top K Frequent Elements ����������뵽�ľ���ʹ�� HashMap ����ÿ�����ֳ��ֵĴ�������ͳ�ơ�
//		Ȼ����ʹ�������������Դ������򣬲�ȡǰk�����ֵ
		
//		����ʹ�õ���TreeMap�ķ���������
//		TreeMap�Ľ���   https://www.cnblogs.com/skywang12345/p/3310928.html
//		TreeMap ��һ�������key-value���ϣ�����ͨ�������ʵ�ֵġ�
//		TreeMap �̳���AbstractMap����������һ��Map����һ��key-value���ϡ�
//		TreeMap ʵ����NavigableMap�ӿڣ���ζ����֧��һϵ�еĵ������������緵�������key���ϡ�
//		TreeMap ʵ����Cloneable�ӿڣ���ζ�����ܱ���¡��
//		TreeMap ʵ����java.io.Serializable�ӿڣ���ζ����֧�����л���
//		TreeMap���ں������Red-Black tree��ʵ�֡���ӳ������������Ȼ˳��������򣬻��߸��ݴ���ӳ��ʱ�ṩ�� Comparator �������򣬾���ȡ����ʹ�õĹ��췽����
//		R-B Tree��ȫ����Red-Black Tree���ֳ�Ϊ�������������һ������Ķ����������
//		�������ÿ���ڵ��϶��д洢λ��ʾ�ڵ����ɫ�������Ǻ�(Red)���(Black)��
//		������Ľ���   http://www.cnblogs.com/skywang12345/p/3245399.html
		
//		TreeMap ��  key ��ÿ�����ֳ��ֵĴ�����value�ǳ����˸ô���������Щ����
		TreeMap<Integer, List<Integer>> treemap = new TreeMap();
		for(int i: map.keySet()){
			int count = map.get(i);
			if(!treemap.containsKey(count)){
				treemap.put(count, new LinkedList<Integer>());
			}
			treemap.get(count).add(i);
		}
		
//		��ΪTreeMap��Ĭ�ϰ���Ȼ˳�����򣬼�����key��ֵ����С��������
//		���Ҫ�õ����ִ�������k������Ҫ�������
		while(result.size()<k){
			Map.Entry<Integer, List<Integer>> entry = treemap.pollLastEntry();
			result.addAll(entry.getValue());
		}	
		return result;	
	}
}
