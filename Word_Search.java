package top_interview;

public class Word_Search {
	
	public static void main(String args[]){
		char test = 'B';
		test^=256;
		test^=256;
		System.out.println(test);
		
		
		char[][] board = {{'A','B','C'},
						  {'C','B','A'},
						  {'A','D','A'},
						  {'F','R','Q'}};
		String word = "ABCAF";
		Word_Search a = new Word_Search();
		if(a.exist(board, word)) System.out.println("True");
		else System.out.println("False");
	}
	
	
//	典型的DFS实现
//	本方法中使用一个二维数组来记录当前点是否被访问过
//	public boolean exist(char[][] board, String word){
//		int m = board.length;
//		if(m==0) return false;
//		int n = board[0].length;
//		boolean[][] visited = new boolean[m][n];
//		for(int i=0;i<m;i++){
//			for(int j=0;j<n;j++){
//				// 从i,j点作为起点开始搜索
//				if(digui(board, visited, word, i, j, 0)) return true;
//			}
//		}
//		return false;
//	}

//	DFS 的实现过程
//	public boolean digui(char[][] board, boolean[][] visited, String word, int i, int j, int index){
//		//如果当前的位置已经超过了board的边界，则返回false		
//		if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return false;
//		
//		if(board[i][j] == word.charAt(index) && !visited[i][j]){
//			
//			//如果当前的字符是word的最后一个字符，则返回true			
//			if(index == word.length()-1) return true;
//	
//			visited[i][j] = true;
//			boolean up = digui(board, visited, word, i+1, j, index+1);
//			boolean down = digui(board, visited, word, i-1, j, index+1);
//			boolean left = digui(board, visited, word, i, j-1, index+1);
//			boolean right = digui(board, visited, word, i, j+1, index+1);
//			
//			//如果当前[i][j]点的 up,down,left,right 均为 false，则当前路线不通，并把当前点标记为：未访问。然后回溯到上一个点。			
//			visited[i][j] = up||down||left||right;
//			
//			return up||down||left||right;
//		}
//		return false;
//	}
	
	
//	还有一种省空间的方法，不使用一个二维数组来记录当前点是否被访问过，
//	而是将访问过的字符替换掉, 之后再替换回来
//	还有一个最简单的方法就是：将当前的字符异或上一个特定数，然后再异或回来
	public boolean exist(char[][] board, String word){
		if(board.length == 0) return false;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(DFS(board, word, i, j, 0)) return true;
			}
		}
		return false;
	}
	
	public boolean DFS(char[][] board, String word, int i, int j, int index){
		if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return false;
		if(board[i][j] == word.charAt(index)){
			char temp = board[i][j];
			board[i][j] = '#';
			if(index == word.length()-1) return true;	
			boolean up = DFS(board, word, i+1, j, index+1);
			boolean down = DFS(board, word, i-1, j, index+1);
			boolean left = DFS(board, word, i, j-1, index+1);
			boolean right = DFS(board, word, i, j+1, index+1);
			if(!(up||down||left||right))  board[i][j] = temp;
			return up||down||left||right ;
		}
		return false;
	}
}
