package LCS;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static String str1; // 첫번째 문자열
	static String str2; // 두번째 문자열
	static int[][] board; // 문자열 공통 부분 카운팅 보드
	static int n; // 첫번째 문자열 길이
	static int m; // 두번째 분자열 길이

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		n = str1.length();
		m = str2.length();

		board = new int[n][m];

		for (int idx1 = 0; idx1 < n; idx1++) {
			for (int idx2 = 0; idx2 < m; idx2++) {
				if (str1.charAt(idx1) == str2.charAt(idx2)) {
					board[idx1][idx2] = findDp(idx1 - 1, idx2 - 1) + 1;
				} else {
					board[idx1][idx2] = Math.max(findDp(idx1 - 1, idx2), findDp(idx1, idx2 - 1));
				}
			}
		}

		System.out.println(board[n - 1][m - 1]);
	}

	private static int findDp(int y, int x) {
		if (y < 0 || x < 0 || y >= n || x >= m)
			return 0;
		return board[y][x];
	}
}
