package 미로탐색_2178;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visited;
	static int n, m, time;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < m; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}

		Queue<Position> queue = new ArrayDeque<>();

		visited[0][0] = true;
		queue.offer(new Position(0, 0));
		time = 1;

		Loop:
		while (!queue.isEmpty()) {
			int queueSize = queue.size();

			for (int i = 0; i < queueSize; i++) {
				Position now = queue.poll();
				if (now.y == n-1 && now.x == m-1)
					break Loop;
				for (int k = 0; k < 4; k++) {
					int newY = now.y + dy[k];
					int newX = now.x + dx[k];

					if (newY < 0 || newX < 0 || newY >= n || newX >= m)
						continue;
					if (visited[newY][newX])
						continue;
					if (map[newY][newX] == 0)
						continue;
					
					visited[newY][newX] = true;
					queue.offer(new Position(newY, newX));
				}
			}
			time++;
		}

		System.out.println(time);
	}
}

class Position {
	int y, x;

	public Position(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
