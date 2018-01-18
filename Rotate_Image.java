package top_interview;

public class Rotate_Image {
	
	public static void main(String args[]){
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		Rotate_Image a = new Rotate_Image();
		a.rotate(matrix);
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		
	}
	
	
//	本题需要将矩阵顺时针旋转90度
//	详细解释    http://blog.csdn.net/SunnyYoona/article/details/18566587
	
//	思路一：
//	假设矩阵中某一元素的index是 (i, j), 矩阵大小为 n,
//	则顺时针旋转90度之后，该元素变为 (j, n-1-i)
//	下面的方法额外使用了一个 swap[][] 数组来判断当前元素是否已进行过旋转，
//	思路虽然简单，但是不符合题目要求，使用了额外的空间
//	public void rotate(int[][] matrix){
//		int n = matrix.length;
//		int swap[][] = new int[n][n];
//		for(int i=0;i<n;i++){
//			for(int j=0;j<n;j++){
//				if(swap[i][j] != 1){
//					int temp = matrix[i][j];
//					matrix[i][j] = matrix[j][n-1-i];
//					matrix[j][n-1-i] = temp;
//					swap[i][j]=1;
//					swap[j][n-1-i]=1;
//				}
//			}
//		}
//	}

	
//	思路二：
//	纯模拟，从外到内一圈一圈的转，但这个方法太慢。
//	A[i][j] -> A[j][n-1-i] -> A[n-1-i][n-1-j] -> A[n-1-j][i] -> A[i][j]
//	public void rotate(int[][] matrix){
//		int n = matrix.length;
//		for(int i=0;i<n/2;i++){
//			for(int j=i;j<n-1-i;j++){
//				int temp = matrix[i][j];
//				matrix[i][j] = matrix[n-1-j][i];
//				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
//				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
//				matrix[j][n-1-i] = temp;
//			}
//		}
//	}
	
	
//	思路三：
//	先沿着副对角线翻转一次，然后沿着水平中线翻转一次
//	或者，先沿着水平中线翻转一次，然后沿着主对角线翻转一次
	public void rotate(int[][] matrix){
		int n = matrix.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n-1-i;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][n-1-i];
				matrix[n-1-j][n-1-i] = temp;
			}
		}
		
		for(int i=0;i<n/2;i++){
			for(int j=0;j<n;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-i][j];
				matrix[n-1-i][j] = temp;
			}
		}
	}
	
}
