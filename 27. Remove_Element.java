package curry;

import java.util.Scanner;

public class RemoveElement_27 {
	
	public static void main(String []args){
		Scanner cin = new Scanner (System.in);
		int n = cin.nextInt();
		int nums[] = new int[n];
		if(cin.hasNext()){
		for(int i=0;i<n;i++){
			nums[i] = cin.nextInt();
		 }
		}
		int val = cin.nextInt();
		RemoveElement_27 a = new RemoveElement_27();
		int length = a.removeElement(nums,val);
		System.out.print(" "+length);
	}
      
	public int removeElement(int []nums,int val){
		
		int i=0;
		for(int j=0;j<nums.length;j++){
			if(nums[j]!=val){
				nums[i]=nums[j];
				i++;
			}
		}
		
		for(int j=0;j<i;j++)
			System.out.print(nums[j]);
		
		return i;
	}
	
	
	
}
