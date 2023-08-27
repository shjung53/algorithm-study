package 정사각형방;

import java.util.*;
import java.io.*;

public class Solution {
	static int[][] board;
	static int n;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int startNum;
	static int count;
	static int maxCount;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			maxCount = Integer.MIN_VALUE;
			answer = Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < 4; k++) {
						int newY = i + dy[k];
						int newX = j + dx[k];
						if (!check(newY, newX))
							continue;
						if (board[i][j] - 1 == board[newY][newX])
							continue;
					}
					
					startNum = board[i][j];
					count = 1;
					count(i, j);
				}
			}

			stb.append('#').append(t).append(' ').append(answer).append(' ').append(maxCount).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static void count(int i, int j) {
		if (count > maxCount) {
			maxCount = count;
			answer = startNum;
		}

		if (count == maxCount) {
			
			if(startNum < answer) answer = startNum;
		}

		for (int k = 0; k < 4; k++) {
			int newY = i + dy[k];
			int newX = j + dx[k];
			if (!check(newY, newX))
				continue;
			if (board[i][j] + 1 == board[newY][newX]) {
				count++;
				count(newY, newX);
				count--;
			}
		}
	}

	private static boolean check(int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n)
			return false;
		return true;
	}
}
