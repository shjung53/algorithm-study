package 주사위굴리기_14499;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, m, x, y, k; // 세로가 y
	static int[][] map;
	static int[] horizontal = { 0, 0, 0, 0 };
	static int[] vertical = { 0, 0, 0, 0 };
	static boolean isVertical = false;
	static int direction = 1; // 1 or -1
	static StringBuilder stb;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		stb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < k; i++) {
			int way = Integer.parseInt(st.nextToken());
			rollDice(way);
		}

		System.out.println(stb);
	}

	static void rollDice(int direction) {
		switch (direction) {
		case 1: {
			// 동쪽
			int newX = x + 1;
			if (x + 1 < 0 || x + 1 >= m)
				return; // 넘으면 패스

			x = newX;

			int temp = horizontal[0];
			for (int j = 0; j < 3; j++) {
				horizontal[j] = horizontal[j + 1];
			}

			if (map[y][x] == 0) {
				map[y][x] = horizontal[0];
			} else {
				horizontal[0] = map[y][x];
				map[y][x] = 0;
			}

			horizontal[3] = temp;
			vertical[0] = horizontal[0];
			vertical[2] = horizontal[2];
			stb.append(horizontal[2]).append('\n');
		}
			return;
		case 2: {
			// 서쪽
			int newX = x - 1;
			if (x - 1 < 0 || x - 1 >= m)
				return; // 넘으면 패스

			x = newX;

			int temp = horizontal[3];
			for (int j = 3; j >= 1; j--) {
				horizontal[j] = horizontal[j - 1];
			}
			horizontal[0] = temp;

			if (map[y][x] == 0) {
				map[y][x] = horizontal[0];
			} else {
				horizontal[0] = map[y][x];
				map[y][x] = 0;
			}
			vertical[0] = horizontal[0];
			vertical[2] = horizontal[2];

			stb.append(horizontal[2]).append('\n');
		}
			return;
		case 3: {
			// 북쪽
			int newY = y - 1;
			if (y - 1 < 0 || y - 1 >= n)
				return; // 넘으면 패스

			y = newY;

			int temp = vertical[3];
			
			for (int j = 3; j >= 1; j--) {
				vertical[j] = vertical[j - 1];
			}
			vertical[0] = temp;

			if (map[y][x] == 0) {
				map[y][x] = vertical[0];
			} else {
				vertical[0] = map[y][x];
				map[y][x] = 0;
			}
			horizontal[0] = vertical[0];
			horizontal[2] = vertical[2];

			stb.append(vertical[2]).append('\n');
		}
			return;
		case 4: {
			// 남쪽
			int newY = y + 1;
			if (y + 1 < 0 || y + 1 >= n)
				return; // 넘으면 패스

			y = newY;

			int temp = vertical[0];
			for (int j = 0; j < 3; j++) {
				vertical[j] = vertical[j + 1];
			}

			if (map[y][x] == 0) {
				map[y][x] = vertical[0];
			} else {
				vertical[0] = map[y][x];
				map[y][x] = 0;
			}

			vertical[3] = temp;
			horizontal[0] = vertical[0];
			horizontal[2] = vertical[2];

			stb.append(vertical[2]).append('\n');
		}
		}
	}
}
