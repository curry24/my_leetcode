import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Two_sum {
	public static void main(String[] args)

	{
	
	Scanner cin = new Scanner(System.in);

	 int n = cin.nextInt();
	 System.out.println(n);
     int[] number = new int[n];
	 if(cin.hasNext()){
         for(int i=0;i<n;i++){
             number[i]=cin.nextInt();
         }
        
     }
	 int t = cin.nextInt();
	 
	 Two_sum zl =new Two_sum();
	 int b[] = new int [2];
	 b=zl.twoSum(number,t);
	 
	 for (int i=0;i<2 ;i++ )
	  {
	   System.out.print(b[i]+" ");
	  }
	 }

	
//  method1	
//	public int[] twoSum(int[] nums, int target) {
//	    for (int i = 0; i < nums.length; i++) {
//	        for (int j = i + 1; j < nums.length; j++) {
//	            if (nums[j] == target - nums[i]) {
//	                return new int[] { i, j };
//	            }
//	        }
//	    }
//	    throw new IllegalArgumentException("No two sum solution");
//	}
	
//  method2	
//	public int[] twoSum(int[] nums, int target) {
//	   
//		Map<Integer,Integer> map = new HashMap();
//		for(int i=0;i<nums.length;i++){
//			map.put(nums[i], i);
//		}
//		
//		for(int i=0;i<nums.length;i++){
//			int goal = target - nums[i];
//			if(map.containsKey(goal)&&map.get(goal)!=i){
//				return new int[]{i,map.get(goal)};
//			}
//		}
//		    throw new IllegalArgumentException("No two sum solution");
//	}

//  method3	
	public int[] twoSum(int[] nums, int target){
		Map<Integer,Integer> map = new HashMap();
		
		for(int i=0;i<nums.length;i++){
			int goal = target - nums[i];
			if(map.containsKey(goal)) return new int[]{i,map.get(goal)};
			map.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}
}
