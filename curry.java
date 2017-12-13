package top_interview;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class curry {
	public static void main(String[] args) throws IOException {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		char nums[][] = new char[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				nums[i][j] = (char) System.in.read();

		curry c = new curry();

		boolean is = c.isValidSudoku(nums);
		System.out.print(is);

		// for(int i=0;i<n;i++)
		// for(int j=0;j<m;j++){
		// System.out.print(nums[i][j]);
		// }

	}

	public boolean isValidSudoku(char[][] board) {
		// System.out.print(board.length);
		// System.out.print(board[0].length);
		// for(int i=0;i<board.length;i++){
		// for(int j=0;j<board[0].length;j++){
		// System.out.print(board[i][j]);
		//
		// }
		// System.out.print("  ");
		// }
		int row = board.length;
		int line = board[0].length;

		for (int i = 0; i < row; i++) {
			HashSet<Character> set = new HashSet<Character>();
			for (int j = 0; j < line; j++) {
				if (board[i][j] != '.') {
					if (set.contains(board[i][j]))
						return false;
					set.add(board[i][j]);
				}
			}
		}

		for (int j = 0; j < line; j++) {
			HashSet<Character> set = new HashSet<Character>();
			for (int i = 0; i < row; i++) {
				if (board[i][j] != '.') {
					if (set.contains(board[i][j]))
						return false;
					set.add(board[i][j]);
				}
			}
		}

		for (int i = 0; i < row; i += 3) {
			for (int j = 0; j < line; j += 3) {
				HashSet<Character> set = new HashSet<Character>();

				for (int hehe = 0; hehe < 9; hehe++) {
					int add_x = hehe % 3;
					int add_y = hehe / 3;

					if (board[i + add_x][j + add_y] != '.') {
						if (set.contains(board[i + add_x][j + add_y]))
							return false;
						set.add(board[i + add_x][j + add_y]);
					}
				}
			}
		}

		return true;

	}

}
