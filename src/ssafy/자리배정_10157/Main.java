package 자리배정_10157;

import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int dir = 0;
	static int c;
	static int r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(br.readLine());

		board = new int[r + 1][c + 1];
		String answer = "";

		int startY = r;
		int startX = 1;

		int x = startX;
		int y = startY;

		for (int i = 1; i <= num; i++) {
			if (noSeat(x, y)) {
				answer = "0";
				break;
			}
			board[y][x] = i;
			if (i == num) {
				answer += x;
				answer += " ";
				answer += r + 1 - y;
			}
			int newX = x + dx[dir];
			int newY = y + dy[dir];
			if (noSeat(newX, newY)) {
				dir = (dir + 1) % 4;
				newX = x + dx[dir];
				newY = y + dy[dir];
			}
			x = newX;
			y = newY;
		}

		System.out.println(answer);
	}

	private static boolean noSeat(int x, int y) {
		if (x <= 0 || x > c || y <= 0 || y > r)
			return true;
		if (board[y][x] > 0)
			return true;
		return false;
	}
}
