package 빙산_2573;

import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static int[][] check;
	static int h;
	static int w;
	static int count;

	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		board = new int[h][w];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count = 1;
		int answer = 0;

		while (count == 1) {
			yearLater();
			count = 0;
			countIceBerg();
			answer++;
		}

		if (count == 0)
			answer = 0;

		System.out.println(answer);

	}

	private static void yearLater() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (board[i][j] > 0) {

					for (int k = 0; k < 4; k++) {
						int newY = i + dy[k];
						int newX = j + dx[k];
						if (check(newY, newX)) {
							if (board[newY][newX] == 0)
								board[i][j]--;
						}
					}

					if (board[i][j] <= 0)
						board[i][j] = -1;

				}
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (board[i][j] < 0) {
					board[i][j] = 0;
				}
			}
		}
	}

	private static void countIceBerg() {
		check = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (board[i][j] > 0 && check[i][j] < 1) {
					count++;
					dfs(i, j);
				}
			}
		}
	}

//	위치 체크하고 연결된 빙산도 체크하러 이동
	private static void dfs(int i, int j) {
		check[i][j] = 1;
		for (int k = 0; k < 4; k++) {
			int newY = i + dy[k];
			int newX = j + dx[k];
			if (check(newY, newX)) {
				if (board[newY][newX] > 0 && check[newY][newX] < 1)
					dfs(newY, newX);
			}
		}
	}

	private static boolean check(int i, int j) {
		if (i < 0 || i >= h || j < 0 || j >= w)
			return false;
		return true;
	}
}
