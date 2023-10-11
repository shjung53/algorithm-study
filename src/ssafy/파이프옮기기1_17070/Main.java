package 파이프옮기기1_17070;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map;
	static int status; // 1은 가로 2는 세로 3은 대각선
	static int n;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());

		map = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j < n + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = 0;

		move(1, 2, 1);
		
		System.out.println(answer);

	}

	// 오른쪽 아래가 n,n에 닿을때까지 움직이기
	private static void move(int y, int x, int status) {
		if (y == n && x == n) {
			answer++;
			return;
		}

		switch (status) {
		case 1: {
			// 가로인 경우 두가지 경우 존재
			int newY = y;
			int newX = x + 1;
			if (checkLimit(newY, newX)) {
				if (check(newY, newX, 1)) {
					move(newY, newX, 1);
				}
			}

			newY = y + 1;
			newX = x + 1;
			if (checkLimit(newY, newX)) {
				if (check(newY, newX, 3)) {
					move(newY, newX, 3);
				}
			}
		}
			break;
		case 2: {
			// 세로인 경우 두가지 경우 존재
			int newY = y + 1;
			int newX = x;
			if (checkLimit(newY, newX)) {
				if (check(newY, newX, 2)) {
					move(newY, newX, 2);
				}
			}

			newY = y + 1;
			newX = x + 1;
			if (checkLimit(newY, newX)) {
				if (check(newY, newX, 3)) {
					move(newY, newX, 3);
				}
			}
		}
			break;
		case 3: {
			// 대각선인 경우 세가지 경우 존재
			int newY = y;
			int newX = x + 1;
			if (checkLimit(newY, newX)) {
				if (check(newY, newX, 1)) {
					move(newY, newX, 1);
				}
			}

			newY = y + 1;
			newX = x;
			if (checkLimit(newY, newX)) {
				if (check(newY, newX, 2)) {
					move(newY, newX, 2);
				}
			}

			newY = y + 1;
			newX = x + 1;
			if (checkLimit(newY, newX)) {
				if (check(newY, newX, 3)) {
					move(newY, newX, 3);
				}
			}
		}
			break;
		}
	}

	private static boolean checkLimit(int y, int x) {
		if (y < 0 || x < 0 || y > n || x > n)
			return false;
		return true;
	}

	// 벽을 침범하는지 확인
	private static boolean check(int y, int x, int status) {
		switch (status) {
		case 1: {
			if (map[y][x] == 1 || map[y][x - 1] == 1)
				return false;
		}
			break;
		case 2:
			if (map[y][x] == 1 || map[y - 1][x] == 1)
				return false;
			break;
		case 3:
			if (map[y][x] == 1 || map[y - 1][x] == 1 || map[y][x - 1] == 1 || map[y - 1][x - 1] == 1)
				return false;
			break;
		}

		return true;
	}

}
