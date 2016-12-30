package curry;

import java.util.Arrays;
import java.util.Scanner;

public class Merge_Sorted_Array {
	public static void main(String []args){
		Scanner cin = new Scanner (System.in);
		int m = cin.nextInt();
		int n = cin.nextInt();
		int nums1[] = new int[m+n];
		if(cin.hasNext()){
		for(int i=0;i<m;i++){
			nums1[i] = cin.nextInt();
		 }
		}
		int nums2[] = new int[n];
		if(cin.hasNext()){
			for(int i=0;i<n;i++)
				nums2[i] = cin.nextInt();
		}
		Merge_Sorted_Array a = new Merge_Sorted_Array();
		a.merge(nums1, m, nums2, n);
		
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i=m-1,j=n-1,pos=m+n-1;
		while(i>=0 && j>=0){
			if(nums1[i]>nums2[j]) nums1[pos--] = nums1[i--];
			else nums1[pos--] = nums2[j--];
		}
		
		while(i>=0) nums1[pos--] = nums1[i--];
		while(j>=0) nums1[pos--] = nums2[j--];
		
//       Arrays.sort(nums1);
       
//       for(i=0;i<m+n;i++)
//       System.out.print(nums1[i]);
    }
}
