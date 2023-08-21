package 회문2;

import java.util.*;
import java.io.*;

public class Solution {
	static char[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			board = new char[100][100];
			int test = Integer.parseInt(br.readLine());
			int max = 0;

			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					board[i][j] = str.charAt(j);
				}
			}

			Loop1: for (int l = 100; l > 0; l--) {
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j < 100; j++) {
						if (100 - j >= l) {
							if (rowCheck(l, i, j)) {
								max = l;
								break Loop1;
							}
						}
						if (100 - i >= l) {
							if (columnCheck(l, i, j)) {
								max = l;
								break Loop1;
							}
						}
					}
				}
			}
			stb.append('#').append(test).append(' ').append(max).append('\n');
		}

		System.out.println(stb.toString());
	}

	private static boolean rowCheck(int l, int i, int j) {
		for (int k = 0; k < l / 2; k++) {
			if (board[i][j + k] != board[i][j + l - k - 1])
				return false;
		}
		return true;
	}

	private static boolean columnCheck(int l, int i, int j) {
		for (int k = 0; k < l / 2; k++) {
			if (board[i + k][j] != board[i + l - k - 1][j])
				return false;
		}
		return true;
	}
}
