package 안전영역;

import java.util.*;
import java.io.*;

public class Main {

	static int[][] board;
	static int[][] cloneBoard;
	static int length;
	static int[] safeArea = new int[101];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		length = Integer.parseInt(br.readLine());
		board = new int[length][length];
		cloneBoard = new int[length][length];

		for (int i = 0; i < length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i <= 100; i++) {
			resetCloneBoard();
			makeDrownedBoard(i);
			countSafeArea(i);
		}
		
		for(int i=0; i<safeArea.length; i++) {
			if(safeArea[i] > answer) answer = safeArea[i];
		}
		System.out.println(answer);

	}
	
	private static void resetCloneBoard() {
		for(int l=0; l<length; l++) {
			for(int p=0; p<length; p++) {
				cloneBoard[l][p] = board[l][p];
			}
		}
	}

	private static void makeDrownedBoard(int height) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (cloneBoard[i][j] <= height) {
					cloneBoard[i][j] = 0;
				}
			}
		}
	}

	private static void countSafeArea(int height) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (cloneBoard[i][j] > 0) {
					eraseSafeArea(i, j);
					safeArea[height]++;
				}
			}
		}
	}

	private static int eraseSafeArea(int y, int x) {
		cloneBoard[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (check(newY, newX)) {
				if (cloneBoard[newY][newX] != 0) {
					eraseSafeArea(newY, newX);
				}
			}
		}
		return 0;
	}

	private static boolean check(int y, int x) {
		return x >= 0 && x < length && y >= 0 && y < length;
	}
}
