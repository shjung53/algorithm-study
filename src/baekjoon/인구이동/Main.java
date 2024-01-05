package 인구이동;

import java.util.*;
import java.io.*;

public class Main {

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] board;
	static int[][] check;
	static int unionNum;
	static int n;
	static int l;
	static int r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		board = new int[n][n];

		int day = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		do {
			check = new int[n][n];
			unionNum = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i][j] == 0) {
						unionNum++;
						unite(i, j);
					}
				}
			}

			if (unionNum < n * n) {
				day++;
			}

			int[] sum = new int[unionNum + 1];
			int[] count = new int[unionNum + 1];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sum[check[i][j]] += board[i][j];
					count[check[i][j]]++;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = sum[check[i][j]] / count[check[i][j]];
				}
			}
		} while (unionNum < n * n);

		System.out.println(day);

	}

	private static void unite(int i, int j) {
		check[i][j] = unionNum;
		for (int k = 0; k < 4; k++) {
			int newY = i + dy[k];
			int newX = j + dx[k];

			if (!check(newY, newX))
				continue;

			if (check[newY][newX] > 0)
				continue;

			if (Math.abs(board[i][j] - board[newY][newX]) >= l && Math.abs(board[i][j] - board[newY][newX]) <= r) {
				unite(newY, newX);
			}
		}
	}

	private static boolean check(int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n)
			return false;
		return true;
	}
}
