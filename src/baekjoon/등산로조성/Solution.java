package 등산로조성;

import java.util.*;
import java.io.*;

public class Solution {

	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static int n;
	static int limit;
	static int[][] board;
	static int startNum;
	static int count;
	static int maxCount;
	static boolean digChance;
	static boolean check[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());

			limit = Integer.parseInt(st.nextToken());

			board = new int[n][n];

			startNum = Integer.MIN_VALUE;

			maxCount = 0;
			
			check = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] > startNum)
						startNum = board[i][j];
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == startNum) {
						check[i][j] = true;
						count = 1;
						digChance = true;
						findRoute(i, j);
						check[i][j] = false;
					}
				}
			}
			stb.append('#').append(t).append(' ').append(maxCount).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static void findRoute(int i, int j) {
		if (count > maxCount)
			maxCount = count;

			for (int k = 0; k < 4; k++) {
			int newY = i + dy[k];
			int newX = j + dx[k];
			if (!check(newY, newX))
				continue;

			if (board[newY][newX] < board[i][j] && !check[newY][newX]) {
				count++;
				check[newY][newX] = true;
				findRoute(newY, newX);
				count--;
				check[newY][newX] = false;
			}

			if (board[newY][newX] >= board[i][j]) {
				if(check[newY][newX]) continue;
				if (!digChance)
					continue;
				int needToDig = board[newY][newX] - (board[i][j] - 1);
				if (limit < needToDig)
					continue;
				board[newY][newX] -= needToDig;
				count++;
				check[newY][newX] = true;
				digChance = false;
				findRoute(newY, newX);
				board[newY][newX] += needToDig;
				count--;
				check[newY][newX] = false;
				digChance = true;

			}

		}

	}

	private static boolean check(int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n)
			return false;
		return true;
	}
}
