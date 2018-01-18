package top_interview;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {
	
	public static void main(String agrs[]){
		int[] nums = {3,2,1,5,6,4,10,9,8,-4,-3,-1};
		int k = 2;
	
		Kth_Largest_Element_in_an_Array a = new Kth_Largest_Element_in_an_Array();
		int result = a.findKthLargest(nums, k);
		System.out.println(result);
	}
	
	
//	ʹ�������С�ѵķ�����
//	ʹ�� PriorityQueue�����ݽṹ
//	public int findKthLargest(int[] nums, int k){
//		
//		Comparator<Integer> cmp = new Comparator<Integer>(){
//			public int compare(Integer o1, Integer o2){
//				return o2-o1;
//			}
//		};
//		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(20, cmp);
//		
//		for(int i=0;i<nums.length;i++){
//			maxHeap.offer(nums[i]);
//		}
//		
//		int i=1;
//		while(i<k){
//			maxHeap.poll();
//			i++;
//		}	
//		return maxHeap.poll();
//	}

	
//	Quick Select ����ѡ�񷽷�    https://en.wikipedia.org/wiki/Quickselect
//	����������һ��˼·�������㷨����� http://www.jianshu.com/p/8c915179fd02
//	��ȡһ����Ŧֵ���������д�����Ŧֵ�ķ�����ߣ�С����Ŧֵ�ķ����ұߣ�
//	���巽��������������ָ�룬������ǲ����ϸ��Ե������������ǻ������档
//	��������Ŧֵ���ڵķֽ��λ����k��˵���ֽ����ǵ�k�������
//	��������ֽ��λ�ô���k������������ͬ��������������ֽ��λ��С��k�������Ұ����ͬ����������
	
	public int findKthLargest(int[] nums, int k){
		
		return QuickSelect(nums, k-1, 0, nums.length-1);
//		����Ϊ������������ͳһ����ֵΪ k-1
	
	}
	
	public int QuickSelect(int[] nums, int k, int start, int end){
		int left = start;
		int right = end;
		int pivot = nums[(start + end) / 2];
		
		while(left <= right){
//			��������������С����Ŧֵ����
			while(left <= right && nums[left] > pivot){
				left++;
			}
//			�������������Ҵ�����Ŧֵ����
			while(left <= right && nums[right] < pivot){
				right--;
			}
//			������������
			if(left <= right){
				swap(nums, left, right);
				left++;
				right--;
			}
		
		}
// 		����˳�ѭ�����������ָ������ָ�����һ���������

// 		��ʱ�����ָ�뻹���ڵ���k��˵����k�����������
		if(start < right && k <= right) return QuickSelect(nums, k, start, right);
//		�����ָ�뻹С�ڵ���k��˵����k��������Ұ��  
		if(end > left && k >= left) return QuickSelect(nums, k, left, end);
		
		return nums[k];
		
	}
	

//	�������������ĺ���
	public void swap(int[] nums, int left, int right){
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
	
}
