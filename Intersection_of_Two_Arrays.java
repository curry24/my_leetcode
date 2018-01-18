package top_interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Intersection_of_Two_Arrays {
	public static void main(String agrs[]){
		int[] nums1 = {1};
		int[] nums2 = {1,1};
		Intersection_of_Two_Arrays a = new Intersection_of_Two_Arrays();
		int[] result = a.intersection(nums1, nums2);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
	}
	
//	Given two arrays, write a function to compute their intersection.
//	Example:
//	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
//	Note:
//	Each element in the result must be unique.
//	The result can be in any order.
	
//	本题要求找到两个数组里面所有的交点
//	并且结果里面的每个元素非重复
	
//	本题可以使用两个 HashSet 来解决，具体如下：
	public int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        HashSet<Integer> temp = new HashSet<Integer>();
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])) temp.add(nums2[i]);
        }
        int[] result = new int[temp.size()];
        int i=0;
        for(Integer num : temp ){
            result[i] = num;
            i++;
        }
        return result;
		
	}
	
	

}
