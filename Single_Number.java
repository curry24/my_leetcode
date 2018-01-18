package top_interview;

import java.util.Scanner;

public class Single_Number {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int nums[] = new int[n];
		if (cin.hasNext()) {
			for (int i = 0; i < n; i++) {
				nums[i] = cin.nextInt();
			}
		}

		// for(int i=0;i<nums.length;i++){
		// System.out.print(nums[i]);
		// }

		Single_Number c = new Single_Number();
		System.out.print(c.singleNumber(nums));

	}

	public int singleNumber(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int s = nums[0];
		for (int i = 1; i < nums.length; i++) {
			s = s ^ nums[i];
		}
		return s;
	}

}
