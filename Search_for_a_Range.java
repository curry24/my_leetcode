package top_interview;

import java.util.Scanner;

public class Search_for_a_Range {
	
	public static void main(String []args){
		Scanner cin = new Scanner (System.in);
		int n = cin.nextInt();
		int a[] = new int [n];
		if(cin.hasNext()){
			for(int i=0;i<n;i++)
				a[i] = cin.nextInt();
		}
		Search_for_a_Range m = new Search_for_a_Range();
		
		int target = cin.nextInt();
		int result[] = new int[2];
		result = m.searchRange(a, target);
		for(int i=0;i<2;i++)
			System.out.println(result[i]);
		}

	public int[] searchRange(int[] nums, int target){  
		int result[] = {-1, -1};
		int head = 0;
		int tail = nums.length;
		if(nums.length == 0) return result;
		if(target<nums[0]||target>nums[nums.length-1]) return result;
		
		while(head<=tail){
			int temp = (head+tail)/2;
			if(target == nums[temp]){
				result[0] = temp;
				result[1] = temp;
				while(result[0]>=0 && nums[result[0]] == target){
					result[0]--;
				}
				while(result[1]<=nums.length-1 && nums[result[1]] == target){
					result[1]++;
				}
				result[0]++;
				result[1]--;
				return result;
				
			}
			else{
				if(target>nums[temp]){
					head = temp+1;
				}
				else{tail = temp-1;}
			}
		}	
		return result;
	}
}
