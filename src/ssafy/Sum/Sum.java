package Sum;

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[100][100];
		for (int test_case = 1; test_case <= 10; test_case++) {
			int max = 0;
			int testNum = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 100; i++) {
				int rowMax = 0;
				int columnMax = 0;
				int rowSum = 0;
				int columnSum = 0;
				for (int j = 0; j < 100; j++) {
					rowSum += board[i][j];
					columnSum += board[j][i];
				}
				rowMax = Math.max(rowMax, rowSum);
				columnMax = Math.max(columnMax, columnSum);
				int colRowMax = Math.max(rowMax, columnMax);
				max = Math.max(max, colRowMax);
			}
			int diagonalMax = 0;
			int diagonalSum1 = 0;
			int diagonalSum2 = 0;
			for (int i = 0; i < 100; i++) {
				diagonalSum1 += board[i][i];
				diagonalSum2 += board[99 - i][i];
			}
			diagonalMax = Math.max(diagonalSum1, diagonalSum2);
			max = Math.max(max, diagonalMax);

			System.out.println("#" + testNum + " " + max);
		}
	}
}
