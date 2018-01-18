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
		
//		Top k ����Ľ�����������ַ�����Ͱ���������С�ѡ�TreeMap��
//		Top K Frequent Elements ����������뵽�ľ���ʹ�� HashMap ����ÿ�����ֳ��ֵĴ�������ͳ�ơ�
//		Ȼ����ʹ�������������Դ������򣬲�ȡǰk�����ֵ
		
//		����ʹ�õ���Ͱ����ķ���������
//		HashMap�м�������Ԫ�أ���ֵ��������Ԫ�س��ֵ�Ƶ�Σ���һһ��Ӧ�ģ������ڰ�ֵ���������ͬʱ��Ҫ��¼���Ӧ��Ԫ�أ����ڴˣ����ǿ��Բ��á�Ͱ���򡱵�˼�롣
//		���������ǰ�����Ԫ�س��ֵ�Ƶ�ν�������ģ���ô��Ͱ����������Χ�ǿ���ȷ���ġ���Ͱ������С�ڵ��ڸ�������Ԫ�صĸ�����
//		���Ϊi��Ͱ���ڴ�������г���Ƶ��Ϊi��Ԫ�ء��������Ϊi��Ͱ��š�ӳ����С�ֵ������i�ġ�������
//		������ɺ󣬱�Ŵ��Ͱ��Ԫ�س��ֵ�Ƶ�θߣ���ˣ����ǡ�����(��ȡͰ��Ŵ��Ͱ��Ԫ��)��ȡͰ�����ݣ�
//		ֱ����ȡ���ݵĸ�������k�����ǽ���ǰͰ��Ԫ��ȡ����ͬһ��Ͱ��Ԫ�س��ֵ�Ƶ����ȣ�,Ȼ��ֹͣȡ���ݣ���ɣ�
	
		List<Integer>[] bucket = new ArrayList[nums.length+1];	//�����㹻������Ͱ 
		for(int i: map.keySet()){
			int count =	map.get(i);
			if(bucket[count] == null) bucket[count] = new ArrayList<Integer>();
			//�ѳ���Ƶ����ͬ��Ԫ�ء��ӡ�����ŵ���Ƶ�ε�Ͱ��
			bucket[count].add(i);
		}
		//������ȡ����  
		for(int i=bucket.length-1;i>0;i--){
			if(bucket[i] != null && result.size()<k){
				result.addAll(bucket[i]);
			}
		}
		
		return result;
 
		
	}

}
