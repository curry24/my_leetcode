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
	
	
//	������Ҫ������˳ʱ����ת90��
//	��ϸ����    http://blog.csdn.net/SunnyYoona/article/details/18566587
	
//	˼·һ��
//	���������ĳһԪ�ص�index�� (i, j), �����СΪ n,
//	��˳ʱ����ת90��֮�󣬸�Ԫ�ر�Ϊ (j, n-1-i)
//	����ķ�������ʹ����һ�� swap[][] �������жϵ�ǰԪ���Ƿ��ѽ��й���ת��
//	˼·��Ȼ�򵥣����ǲ�������ĿҪ��ʹ���˶���Ŀռ�
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

	
//	˼·����
//	��ģ�⣬���⵽��һȦһȦ��ת�����������̫����
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
	
	
//	˼·����
//	�����Ÿ��Խ��߷�תһ�Σ�Ȼ������ˮƽ���߷�תһ��
//	���ߣ�������ˮƽ���߷�תһ�Σ�Ȼ���������Խ��߷�תһ��
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
