package 아기상어_16236;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, sharkSize, upToEat, y, x, second;
	static int[][] map;
	static int[] dy = { -1, 0, 0, 1 }; // 같은 거리일 경우 가장 위가 우선, 같은 행일 경우 왼쪽이 우선
	static int[] dx = { 0, -1, 1, 0 };
	static boolean[][] visited;
	static Queue<Position> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		visited = new boolean[n][n];
		sharkSize = 2;
		upToEat = 2;
		second = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					y = i;
					x = j;
					map[i][j] = 0;
				}
			}
		}

		while (true) {
			queue = new ArrayDeque<Position>();
			visited = new boolean[n][n];
			visited[y][x] = true;
			queue.offer(new Position(y, x));
			if (findNearestFish()) {
				continue;
			} else {
				break;
			}
		}

		System.out.println(second);

	}

	private static boolean findNearestFish() {
		int distance = 1;
		while (!queue.isEmpty()) {
			int queueSize = queue.size();

			for (int i = 0; i < queueSize; i++) {
				Position now = queue.poll();

				for (int k = 0; k < 4; k++) {
					int newY = now.y + dy[k];
					int newX = now.x + dx[k];

					if (newY < 0 || newX < 0 || newY >= n || newX >= n)
						continue;

					if (map[newY][newX] > sharkSize)
						continue;

					if (map[newY][newX] < sharkSize && map[newY][newX] > 0) {
						second += distance;
						y = newY;
						x = newX;
						map[y][x] = 0;
						upToEat--;

						if (upToEat == 0) {
							sharkSize++;
							upToEat = sharkSize;
						}

						return true;

					}

					if (visited[newY][newX])
						continue;
					visited[newY][newX] = true;
					queue.offer(new Position(newY, newX));
				}
			}

			distance++;
		}

		return false;

	}
}

class Position {
	int y, x;

	public Position(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
