package 로봇청소기_14503;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] cleaned;
	static int n, m, direction;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cleaned = new boolean[n][m];
		st = new StringTokenizer(br.readLine().trim());

		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int count = 0;
		boolean working = true;
		direction = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (working) {
			if (!cleaned[y][x]) {
				cleaned[y][x] = true;
				count++;
			}

			boolean cleanAround = true;

			// 반시계 방향으로 돌면서 청소 안했는지 확인
			for (int k = 1; k <= 4; k++) {
				int newDirection = (direction + k * 3) % 4; // 반시계 방향
				int newY = y + dy[newDirection];
				int newX = x + dx[newDirection];
				if (map[newY][newX] == 1)
					continue; // 벽 확인

				if (!cleaned[newY][newX]) {
					cleanAround = false;
					direction = newDirection;
					break;
				}
			}

			if (cleanAround) {
				int newDirection = (direction + 2) % 4;
				int newY = y + dy[newDirection];
				int newX = x + dx[newDirection];
				if (map[newY][newX] == 1) {
					working = false;
				} else {
					y = newY;
					x = newX;
				}
			} else {
				y = y + dy[direction];
				x = x + dx[direction];
			}

		}

		System.out.println(count);

	}
}
