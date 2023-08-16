package Array_Practice3;

public class Solution {
	public static void main(String[] args) {
		int[][] board = { { 9, 20, 2, 18, 11 }, { 19, 1, 25, 3, 21 }, { 8, 24, 10, 17, 7 }, { 15, 4, 16, 5, 6 },
				{ 12, 13, 22, 23, 14 } };

		Direction dir = Direction.right;

		int startX = 0;
		int startY = 0;
		int x = startX;
		int y = startY;

		while (startX != 2 && startY != 2) {
			int min = Integer.MAX_VALUE;

			if (board[y][x] < min)
				min = board[y][x];

			switch (dir) {
			case right:
				x++;
				break;
			case left:
				x--;
				break;
			case down:
				y++;
				break;
			case up:
				y--;
				break;
			}

		}
	}
}

enum Direction {
	right, down, left, up
}
