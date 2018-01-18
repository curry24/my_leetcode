package top_interview;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
	public static void main(String args[]){
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		Spiral_Matrix a = new Spiral_Matrix();
		List result = a.spiralOrder(matrix);
		System.out.println(result);
		
	}
	
	
//	������������
//	ʹ�õݹ�ķ���
//	һ��һ�㣬�������ڽ��б�������Ҫ����ÿһ���������ʼ����ֹ��λ��
//	������Ҫ��һЩ��������жϣ������ظ�����
	public List<Integer> spiralOrder(int[][] matrix){
		List<Integer> result = new ArrayList<Integer>();
		int m = matrix.length;
		if(matrix == null || m == 0) return result; 
		int n = matrix[0].length;
		digui(matrix, 0, n-1, 0, m-1, result);
		return result;
	}

//	h ������ű����� s �������ű���
	public void digui(int[][] matrix, int h_start, int h_end, int s_start, int s_end, List<Integer> result){
		if(h_start<=h_end && s_start<=s_end){
			for(int i=h_start;i<=h_end;i++) result.add(matrix[s_start][i]);
			for(int j=s_start+1;j<=s_end;j++) result.add(matrix[j][h_end]);
			if(s_start != s_end){
				for(int k=h_end-1;k>=h_start;k--) result.add(matrix[s_end][k]);
			}
			if(h_start != h_end){
				for(int m=s_end-1;m>=s_start+1;m--) result.add(matrix[m][h_start]);
			}
			digui(matrix, h_start+1, h_end-1, s_start+1, s_end-1, result);
		}
	}
}
