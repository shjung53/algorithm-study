package 빙고;

import java.util.*;
import java.io.*;

public class Main {

	static int[][] board;
	static int line = 0;
	static int[] location = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;
		board = new int[5][5];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Call: for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				answer++;
				int callNum = Integer.parseInt(st.nextToken());
				String xy = eraseNum(callNum);
				if (xy != "") {
					int x = Character.getNumericValue(xy.charAt(0));
					int y = Character.getNumericValue(xy.charAt(1));
					checkLine(x, y);
					checkDiagonal(x, y);

					if (line >= 3) {
						break Call;
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static String eraseNum(int callNum) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == callNum) {
					board[i][j] = 0;
					return "" + i + j;
				}
			}
		}
		return null;
	}

	private static void checkLine(int x, int y) {
		boolean checkCol = true;
		boolean checkRow = true;
		for (int i = 0; i < 5; i++) {
			if (board[i][y] != 0)
				checkCol = false;
		}
		if (checkCol)
			line++;
		for (int i = 0; i < 5; i++) {
			if (board[x][i] != 0)
				checkRow = false;
		}
		if (checkRow)
			line++;

	}

	private static void checkDiagonal(int x, int y) {
		boolean check1 = true;
		boolean check2 = true;

		if (x == y) {
			for (int i = 0; i < 5; i++) {
				if (board[i][i] != 0)
					check1 = false;
			}
			if (check1)
				line++;
		}

		if (x + y == 4 && x != y) {
			for (int i = 0; i < 5; i++) {
				if (board[4 - i][i] != 0)
					check2 = false;
			}
			if (check2)
				line++;
		}

		if (x == 2 && y == 2) {
			for (int i = 0; i < 5; i++) {
				if (board[4 - i][i] != 0)
					check2 = false;
			}
			if (check2)
				line++;
		}

	}
}
