package LCS;

import java.util.*;
import java.io.*;

// https://st-lab.tistory.com/139

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
					// 한쪽에만 추가된 건 의미가 X 양쪽에 같은 문자가 추가됐으면 LCS + 1
					board[idx1][idx2] = findDp(idx1 - 1, idx2 - 1) + 1;
				} else {
					// 추가된 문자가 같지 않으면 한쪽의 문자열 중 더 큰 값을 이어받음
					board[idx1][idx2] = Math.max(findDp(idx1 - 1, idx2), findDp(idx1, idx2 - 1));
				}
			}
		}

		System.out.println(board[n - 1][m - 1]);
	}

	private static int findDp(int y, int x) {
		// 범위를 벗어나면 0을 반환
		if (y < 0 || x < 0 || y >= n || x >= m)
			return 0;
		return board[y][x];
	}
}
