package top_interview;

import java.util.HashSet;

public class Find_the_Duplicate_Number {
	public static void main(String args[]){
		int nums[] = {1,1};
		Find_the_Duplicate_Number a = new Find_the_Duplicate_Number();
		System.out.println(a.findDuplicate(nums));
		
	}
	
//	参考博客链接(讲解的很清楚)https://segmentfault.com/a/1190000003817671#articleHeader7
	
//	方法1：哈希表法
//	时间: O(N)  空间:O(N), 不符合题目要求
//	public int findDuplicate(int[] nums){
//		HashSet<Integer> set = new HashSet();
//		if(nums == null || nums.length<=1) return -1;
//		int result=0;
//		for(int i=0;i<nums.length;i++){
//			if(set.contains(nums[i])){
//				result = nums[i];
//				break;
//			}
//			else set.add(nums[i]);
//		}
//		
//		return result;
//	}
	
	
//	方法2：暴力法
//	时间:O(N^2)  空间:O(1)
	
	
//	方法3：排序法
//	时间 :O(NlogN)   空间:O(1)
	
	
//	方法4：二分法
//	时间:O(NlogN)  空间:O(1)
	
	
//	方法5：映射找环法
//	时间:O(N)   空间：O(1)
//	假设数组中没有重复，那我们可以做到这么一点，就是将数组的下标和1到n每一个数一对一的映射起来。
//	比如数组是213,则映射关系为0->2, 1->1, 2->3。
//	假设这个一对一映射关系是一个函数f(n)，其中n是下标，f(n)是映射到的数。
//	如果我们从下标为0出发，根据这个函数计算出一个值，以这个值为新的下标，再用这个函数计算，以此类推，直到下标超界。

//	实际上可以产生一个类似链表一样的序列。比如在这个例子中有两个下标的序列，0->2->3。
//	但如果有重复的话，这中间就会产生多对一的映射，比如数组2131,则映射关系为0->2, {1，3}->1, 2->3。
//	这样，我们推演的序列就一定会有环路了，这里下标的序列是0->2->3->1->1->1->1->...，而环的起点就是重复的数。
//	所以该题实际上就是找环路起点的题，和Linked_List_Cycle_2一样。
//	我们先用快慢两个下标都从0开始，快下标每轮映射两次，慢下标每轮映射一次，直到两个下标再次相同。
//	这时候保持slow下标位置不变，再将fast下标从0开始，这两个下标都继续每轮映射一次，
//	当这两个下标相遇时，就是环的起点，也就是重复的数。对这个找环起点算法不懂的，请参考Floyd's Algorithm。
	public int findDuplicate(int[] nums){
		if(nums == null || nums.length <= 1) return -1;
		int fast=0;
		int slow=0;
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		while(fast != slow);
		
		fast = 0;
		while(fast != slow){
			fast = nums[fast];
			slow = nums[slow];
		}
		return fast;	
	}

}
