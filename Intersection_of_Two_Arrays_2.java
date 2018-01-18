package top_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersection_of_Two_Arrays_2 {
	public static void main(String args[]){
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		Intersection_of_Two_Arrays_2 a = new Intersection_of_Two_Arrays_2();
		int[] result = a.intersect(nums1, nums2);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
	}
	
//	Given two arrays, write a function to compute their intersection.
//	Example:
//	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
//	Note:
//	Each element in the result should appear as many times as it shows in both arrays.
//	The result can be in any order.

//	����Ҫ���ҵ����������������еĽ���
//	���ҽ�������ÿ��Ԫ�غͽ���ĸ�����ͬ
//	������ Intersection_of_Two_Arrays ��Ŀ��������ֻ����ǰһ���� HashSet �����
//	���������ʹ�� HashMap ���������¼�µ�һ��������ÿ�����ֳ��ֵĴ�����
//	Ȼ������ڶ������飬��һ�� list ����¼��������Ľ��㡣
	public int[] intersect(int[] nums1, int[] nums2){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums1.length;i++){
			if(!map.containsKey(nums1[i])) map.put(nums1[i], 1);
			else{
				int counts = map.get(nums1[i]); 
				counts++;
                map.put(nums1[i], counts);
			}
		}
		
		List<Integer> temp = new ArrayList<Integer>();
	    for(int i=0;i<nums2.length;i++){
	    	if(map.containsKey(nums2[i])){
	    		if(map.get(nums2[i]) > 0){
	    			temp.add(nums2[i]);
	                map.put(nums2[i], map.get(nums2[i])-1);
	            }
	        }
	    }
	    
	    int[] result = new int[temp.size()];
	    for(int i=0;i<result.length;i++){
	    	result[i] = temp.get(i);
	    }
	    
	    return result;
		
		
	}
}
