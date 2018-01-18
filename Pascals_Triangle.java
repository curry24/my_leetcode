package top_interview;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
	public static void main(String args[]){
		int numRows = 5;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Pascals_Triangle a = new Pascals_Triangle();
		result = a.generate(numRows);
		System.out.println(result);
	}
	
//	本题要求构建一个杨辉三角形
//	按照杨辉三角形的构建规则，逐层进行构建即可
//	[
//	     [1],
//	    [1,1],
//	   [1,2,1],
//	  [1,3,3,1],
//	 [1,4,6,4,1]
//	]
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(numRows <= 0) return result;
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		result.add(temp);
		if(numRows == 1) return result;
		for(int row=2; row<=numRows; row++){
			int n = result.size();
			temp = new ArrayList<Integer>(result.get(n-1));
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			for(int i=0;i<temp.size()-1;i++){
				int sum = temp.get(i)+temp.get(i+1);
				list.add(sum);
			}
			list.add(1);
			result.add(list);
		}
		return result;
	}

}
