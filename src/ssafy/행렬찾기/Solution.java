package 행렬찾기;

import java.util.*;
import java.io.*;

public class Solution {

	static int n;
	static int[][] board;

	// 행렬의 크기 구하기
	public static Matrix makeSubMatrix(int y, int x) {
		int rowCount = 0;
		int colCount = 0;

		int nextY = y;
		int nextX = x;

		while (board[y][nextX] > 0) {
			colCount++;
			nextX++;
		}

		while (board[nextY][x] > 0) {
			rowCount++;
			nextY++;
		}

		for (int i = y; i < nextY; i++) {
			for (int j = x; j < nextX; j++) {
				board[i][j] = 0;
			}
		}

		return new Matrix(rowCount * colCount, rowCount, colCount);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {

			// 테스트케이스별로 n과 board 초기화
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			// n^n 배열 입력받기
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			PriorityQueue<Matrix> queue = new PriorityQueue<Matrix>(1, new Comparator<Matrix>() {

				@Override
				public int compare(Matrix o1, Matrix o2) {
					// TODO Auto-generated method stub
					if (o1.size == o2.size)
						return o1.rowCount - o2.rowCount;
					return o1.size - o2.size;
				}
			});

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] > 0) {
						queue.offer(makeSubMatrix(i, j));
					}
				}
			}

			stb.append('#').append(tc).append(' ').append(queue.size()).append(' ');
			while (!queue.isEmpty()) {
				Matrix subMatrix = queue.poll();
				stb.append(subMatrix.rowCount).append(' ').append(subMatrix.colCount).append(' ');
			}

			stb.append('\n');
		}

		System.out.println(stb.toString());
	}
}

class Matrix {
	int size;
	int rowCount;
	int colCount;

	public Matrix(int size, int rowCount, int colCount) {
		super();
		this.size = size;
		this.rowCount = rowCount;
		this.colCount = colCount;
	}

}
