package top_interview;

import java.util.Scanner;

public class Longest_Increasing_Subsequence {
	
	public static void main(String []args){
		Scanner cin = new Scanner(System.in);
    	int n = cin.nextInt();
    	int nums[] = new int[n];
    	if(cin.hasNext()){
    		for(int i=0;i<n;i++){
    			nums[i] = cin.nextInt();
    		 }
    		}
    	
    	Longest_Increasing_Subsequence a = new Longest_Increasing_Subsequence();
    	System.out.print(a.lengthOfLIS(nums));
	}
	
	// ��̬�滮��
	// ����ÿһ��λ����������ɵ�LIS�ĳ��� LIS[i]
	// �� LIS[i] = LIS[j] + 1 (nums[j]<nums[i], LIS[j]�� iǰ���λ���ϵ�����LIS�ĳ���)
	public int lengthOfLIS(int[] nums) {
		
		if(nums.length==0) return 0;
		
		int LIS[] = new int[nums.length];
	    LIS[0] = 1;
	    int maxlen = 1;
	    for(int i=1;i<nums.length;i++){
	    	for(int j=0;j<i;j++){
	    		if(nums[j]<nums[i]){
	    			LIS[i] = Math.max(LIS[i], LIS[j]);
	    		}
	    	}
	    	LIS[i] = LIS[i] + 1;
	    	
	    	maxlen = Math.max(maxlen, LIS[i]);
	    	
	    }
	    
	    return maxlen;
	 }

}
