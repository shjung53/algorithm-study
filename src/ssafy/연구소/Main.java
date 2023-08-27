package 연구소;

import java.util.*;
import java.io.*;

public class Main {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] board;
	static int[][] clone;
	static int n;
	static int m;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		answer = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(answer);

	}

	private static void dfs(int wall) {
		if (wall == 3) {
			countVirus();
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) {
					board[i][j] = 1;
					dfs(wall + 1);
					board[i][j] = 0;
				}
			}
		}
	}

	private static void countVirus() {
		clone = new int[n][m];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				clone[i][j] = board[i][j];
			}
		}

		bfs();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (clone[i][j] == 0) {
					sum++;
				}
			}
		}
		
		if(sum > answer) answer = sum;
	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (clone[i][j] == 2) {
					queue.offer(new Point(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			Point v = queue.poll();
			int y = v.y;
			int x = v.x;

			for (int k = 0; k < 4; k++) {
				int newY = y + dy[k];
				int newX = x + dx[k];
				if (!check(newY, newX))
					continue;
				if(clone[newY][newX] == 0) {
					clone[newY][newX] = 2;
					queue.offer(new Point(newY, newX));
				}

			}
		}
	}

	private static boolean check(int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= m)
			return false;
		return true;
	}
}

class Point {
	int y;
	int x;

	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}

}
