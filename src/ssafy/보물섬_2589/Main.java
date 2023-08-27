package 보물섬_2589;

import java.util.*;
import java.io.*;

public class Main {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static char[][] board;
	static boolean[][] visited;
	static int h;
	static int w;
	static int min;
	static int answer;
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		board = new char[h][w];

		for (int i = 0; i < h; i++) {
			String str = br.readLine();
			for (int j = 0; j < w; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		answer = Integer.MIN_VALUE;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (board[i][j] != 'L')
					continue;
				visited = new boolean[h][w];
				int len = bfs(i, j);
				answer = Math.max(answer, len);
			}
		}

		System.out.println(answer);

	}

	private static boolean check(int i, int j) {
		if (i < 0 || i >= h || j < 0 || j >= w) {
			return false;
		}
		return true;
	}

	private static int bfs(int i, int j) {
		queue = new ArrayDeque<>();
		queue.offer(new Point(i, j));
		int level = 0;
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			for (int k = 0; k < queueSize; k++) {
				Point p = queue.poll();
				int y = p.y;
				int x = p.x;
				visited[y][x] = true;
				for (int l = 0; l < 4; l++) {
					int newY = y + dy[l];
					int newX = x + dx[l];
					if (!check(newY, newX))
						continue;
					if (board[newY][newX] == 'L' && !visited[newY][newX]) {
						visited[newY][newX] = true;
						queue.offer(new Point(newY, newX));
					}
				}
			}
			if (queue.size() > 0)
				level++;
		}
		return level;
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
