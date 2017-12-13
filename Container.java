package top_interview;

import java.util.Scanner;

public class Container {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int height[] = new int[n];
		if (cin.hasNext()) {
			for (int i = 0; i < n; i++) {
				height[i] = cin.nextInt();
			}
		}

		Container c = new Container();
		System.out.print(c.maxArea(height));

	}

	// public int maxArea(int[] height) {
	// int max=0;
	// int temp;
	// for(int i=0;i<height.length;i++)
	// System.out.print(height[i]);
	//
	// for(int i=0;i<height.length;i++)
	// for(int j=i+1;j<height.length;j++){
	// temp = (j-i)*Math.min(height[i], height[j]);
	// max = Math.max(max, temp);
	// }
	//
	// return max;
	// }

	// 从两边开始，不断选择两边中最短的边，向中间移动
	public int maxArea(int[] height) {
		int i = 0, j = height.length - 1;
		int max = 0;
		int temp;
		while (i < j) {
			temp = (j - i) * Math.min(height[i], height[j]);
			max = Math.max(max, temp);
			if (height[i] <= height[j])
				i++;
			else
				j--;
		}
		return max;
	}
}
