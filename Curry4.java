package top_interview;


import java.util.Scanner;

public class Curry4 {
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		int size = cin.nextInt();
		int nums[] = new int[size];
		if(cin.hasNext()){
			for(int i=0;i<size;i++)
				nums[i] = cin.nextInt();
		}
		
		
		Curry4 c = new Curry4();
		
		System.out.print(c.removeDuplicates(nums));
	}
	
	
	
	
	public int removeDuplicates(int[] nums) {
      if(nums.length==0) return 0;
      int i=0;
      for(int j=1;j<nums.length;j++){
    	  if(nums[j]!=nums[i]){
    		  i++;
    		  nums[i]=nums[j];
    	  }
      }
      
      for(int j=0;j<i+1;j++)
   	   System.out.print(nums[j]+" ");
      
      return i+1; 
       
      
    }
	

}
