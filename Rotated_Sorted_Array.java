package top_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rotated_Sorted_Array {
	
	public static void main(String []args){
		Scanner cin = new Scanner (System.in);
		int n = cin.nextInt();
		int a[] = new int [n];
		if(cin.hasNext()){
			for(int i=0;i<n;i++)
				a[i] = cin.nextInt();
		}
		Rotated_Sorted_Array m = new Rotated_Sorted_Array();
		
		int target = cin.nextInt();
		
		System.out.print(m.search(a, target));
		}
	
//		public int search(int[] nums, int target) {   // 递归实现基本二分法查找
//	        if(target<nums[0]||target>nums[nums.length-1]) return -1;
//			int result = 0;
//	        result = find(0, nums.length-1, nums, target);
//	        return result;
//	    }
//		
//		public int find(int head, int tail, int[] nums, int target){ 
//			
//			int temp = (head+tail)/2;
//			if(nums[temp]==target) return temp;
//			else if(head>tail) return -1;
//			else{ 
//				if(nums[temp]<target) return find(temp+1, tail, nums, target);
//				else return find(head, temp-1, nums, target);
//			}
//		}
	
//		public int search(int[] nums, int target){  // 循环实现基本二分法查找
//			int head = 0;
//			int tail = nums.length;
//			if(target<nums[0]||target>nums[nums.length-1]) return -1;
//			
//			while(head<=tail){
//				int temp = (head+tail)/2;
//				if(target == nums[temp]) return temp;
//				else{
//					if(target>nums[temp]){
//						head = temp+1;
//					}
//					else{tail = temp-1;}
//				}
//			}	
//			return -1;
//		}
		
	
		public int search(int []nums, int target){   // 旋转数组二分法
			int head = 0;
			int tail = nums.length-1;
			
			while(head<=tail){
				int temp = (head+tail)/2;	
				if(target == nums[temp]) return temp;
				else{
					if(nums[temp]<nums[tail]){
						if(target>nums[temp] && target<=nums[tail])
							head = temp+1;
						else tail = temp-1;
					}
					else{
						if(target>=nums[head] && target<nums[temp])
							tail = temp-1;
						else head = temp+1;
					}
				}
				
			}
			return -1;
			
		}
		

}
