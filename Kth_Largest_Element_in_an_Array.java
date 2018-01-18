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
	
	
//	使用最大最小堆的方法；
//	使用 PriorityQueue的数据结构
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

	
//	Quick Select 快速选择方法    https://en.wikipedia.org/wiki/Quickselect
//	跟快速排序一个思路。排序算法详见： http://www.jianshu.com/p/8c915179fd02
//	先取一个枢纽值，将数组中大于枢纽值的放在左边，小于枢纽值的放在右边，
//	具体方法是用左右两个指针，如果他们不符合各自的条件，则将他们换到对面。
//	如果这个枢纽值所在的分界点位置是k，说明分界点就是第k大的数。
//	否则，如果分界点位置大于k，则在左半边做同样的搜索。如果分界点位置小于k，则在右半边做同样的搜索。
	
	public int findKthLargest(int[] nums, int k){
		
		return QuickSelect(nums, k-1, 0, nums.length-1);
//		这里为了与数组坐标统一，赋值为 k-1
	
	}
	
	public int QuickSelect(int[] nums, int k, int start, int end){
		int left = start;
		int right = end;
		int pivot = nums[(start + end) / 2];
		
		while(left <= right){
//			从左向右依次找小于枢纽值的数
			while(left <= right && nums[left] > pivot){
				left++;
			}
//			从右向左依次找大于枢纽值的数
			while(left <= right && nums[right] < pivot){
				right--;
			}
//			将两个数互换
			if(left <= right){
				swap(nums, left, right);
				left++;
				right--;
			}
		
		}
// 		最后退出循环的情况是右指针在左指针左边一格或者两格

// 		这时如果右指针还大于等于k，说明第k大的数在左半边
		if(start < right && k <= right) return QuickSelect(nums, k, start, right);
//		如果左指针还小于等于k，说明第k大的数在右半边  
		if(end > left && k >= left) return QuickSelect(nums, k, left, end);
		
		return nums[k];
		
	}
	

//	将两个数互换的函数
	public void swap(int[] nums, int left, int right){
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
	
}
