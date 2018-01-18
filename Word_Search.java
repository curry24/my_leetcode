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
	
	
//	���͵�DFSʵ��
//	��������ʹ��һ����ά��������¼��ǰ���Ƿ񱻷��ʹ�
//	public boolean exist(char[][] board, String word){
//		int m = board.length;
//		if(m==0) return false;
//		int n = board[0].length;
//		boolean[][] visited = new boolean[m][n];
//		for(int i=0;i<m;i++){
//			for(int j=0;j<n;j++){
//				// ��i,j����Ϊ��㿪ʼ����
//				if(digui(board, visited, word, i, j, 0)) return true;
//			}
//		}
//		return false;
//	}

//	DFS ��ʵ�ֹ���
//	public boolean digui(char[][] board, boolean[][] visited, String word, int i, int j, int index){
//		//�����ǰ��λ���Ѿ�������board�ı߽磬�򷵻�false		
//		if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return false;
//		
//		if(board[i][j] == word.charAt(index) && !visited[i][j]){
//			
//			//�����ǰ���ַ���word�����һ���ַ����򷵻�true			
//			if(index == word.length()-1) return true;
//	
//			visited[i][j] = true;
//			boolean up = digui(board, visited, word, i+1, j, index+1);
//			boolean down = digui(board, visited, word, i-1, j, index+1);
//			boolean left = digui(board, visited, word, i, j-1, index+1);
//			boolean right = digui(board, visited, word, i, j+1, index+1);
//			
//			//�����ǰ[i][j]��� up,down,left,right ��Ϊ false����ǰ·�߲�ͨ�����ѵ�ǰ����Ϊ��δ���ʡ�Ȼ����ݵ���һ���㡣			
//			visited[i][j] = up||down||left||right;
//			
//			return up||down||left||right;
//		}
//		return false;
//	}
	
	
//	����һ��ʡ�ռ�ķ�������ʹ��һ����ά��������¼��ǰ���Ƿ񱻷��ʹ���
//	���ǽ����ʹ����ַ��滻��, ֮�����滻����
//	����һ����򵥵ķ������ǣ�����ǰ���ַ������һ���ض�����Ȼ����������
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
