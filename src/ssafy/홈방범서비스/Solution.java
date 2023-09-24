package 홈방범서비스;

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int allHouse;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new int[n][n];
			allHouse = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						allHouse++;
				}
			}

			int answer = 0;

			Loop:
			for (int k = 1; k <= 2 * n - 1; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						visited = new boolean[n][n];
						bfs(i, j, k);
						int house = count();
						int profit = (house * m) - (k * k + (k - 1) * (k - 1));
						if (profit >= 0) {
							if (house > answer)
								answer = house;
						}
						
						if(house == allHouse) break Loop;
					}
				}
			}

			stb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static void bfs(int i, int j, int k) {
		Queue<Point> queue = new ArrayDeque<>();

		int level = 0;
		visited[i][j] = true;
		queue.offer(new Point(i, j));

		while (!queue.isEmpty()) {
			int queueSize = queue.size();

			level++;

			if (level == k)
				break;

			for (int l = 0; l < queueSize; l++) {
				Point now = queue.poll();

				for (int d = 0; d < dx.length; d++) {
					int newY = now.y + dy[d];
					int newX = now.x + dx[d];

					if (newY < 0 || newY >= n || newX < 0 || newX >= n)
						continue;

					if (visited[newY][newX])
						continue;

					visited[newY][newX] = true;
					queue.offer(new Point(newY, newX));
				}
			}
		}
	}

	private static int count() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] && map[i][j] == 1)
					count++;
			}
		}
		return count;
	}
}

class Point {
	int y;
	int x;

	public Point(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

}
