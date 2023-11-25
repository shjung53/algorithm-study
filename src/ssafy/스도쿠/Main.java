package 스도쿠;

import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static BufferedReader br;
	static String answer = "";

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String st = br.readLine().trim();
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
			}
		}

		play(0, 0, "");

		StringBuilder stb = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			String sub = answer.substring(i * 9, i * 9 + 9);
			for (int j = 0; j < 9; j++) {
				stb.append(sub.charAt(j));
			}
			stb.append('\n');
		}

		System.out.println(stb);
	}

	private static void play(int yIndex, int xIndex, String str) {
		if (yIndex >= 9) {

			for (int i = 0; i < 9; i++) {
				if (!row(i))
					return;
				if (!column(i))
					return;
			}

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (i % 3 == 0 || j % 3 == 0) {
						if (!square(i, j))
							return;
					}
				}
			}

			if (answer.compareTo(str) > 0) {
				answer = str;
			}
			answer = str;
			return;
		}

		if (map[yIndex][xIndex] == 0) {
			for (int i = 1; i <= 9; i++) {
				map[yIndex][xIndex] = i;

				if (xIndex == 8) {
					play(yIndex + 1, 0, str + i);
				} else {
					play(yIndex, xIndex + 1, str + i);
				}
				map[yIndex][xIndex] = 0;
			}
		}

		if (xIndex == 8) {
			play(yIndex + 1, 0, str + map[yIndex][xIndex]);
		} else {
			play(yIndex, xIndex + 1, str + map[yIndex][xIndex]);
		}

	}

	static private boolean row(int yIndex) {
		boolean[] check = new boolean[10];
		for (int i = 0; i < 9; i++) {
			check[map[yIndex][i]] = true;
		}

		for (int i = 1; i <= 9; i++) {
			if (!check[i])
				return false;
		}
		return true;
	}

	static private boolean column(int xIndex) {
		boolean[] check = new boolean[10];
		for (int i = 0; i < 9; i++) {
			check[map[i][xIndex]] = true;
		}

		for (int i = 1; i <= 9; i++) {
			if (!check[i])
				return false;
		}
		return true;
	}

	static private boolean square(int y, int x) {
		if (y >= 0 && y <= 2) {
			if (x >= 0 && x <= 2) {
				for (int i = 0; i <= 2; i++) {
					for (int j = 0; j <= 2; j++) {
						if (y == i && x == j)
							continue;
						if (map[y][x] == map[i][j])
							return false;
					}
				}
			}

			if (x >= 3 && x <= 5) {
				for (int i = 0; i <= 2; i++) {
					for (int j = 3; j <= 5; j++) {
						if (y == i && x == j)
							continue;
						if (map[y][x] == map[i][j])
							return false;
					}
				}
			}

			if (x >= 6 && x <= 8) {
				for (int i = 0; i <= 2; i++) {
					for (int j = 6; j <= 8; j++) {
						if (y == i && x == j)
							continue;
						if (map[y][x] == map[i][j])
							return false;
					}
				}
			}
		}

		if (y >= 3 && y <= 5) {
			if (x >= 0 && x <= 2) {
				for (int i = 3; i <= 5; i++) {
					for (int j = 0; j <= 2; j++) {
						if (y == i && x == j)
							continue;
						if (map[y][x] == map[i][j])
							return false;
					}
				}
			}

			if (x >= 3 && x <= 5) {
				for (int i = 3; i <= 5; i++) {
					for (int j = 3; j <= 5; j++) {
						if (y == i && x == j)
							continue;
						if (map[y][x] == map[i][j])
							return false;
					}
				}
			}

			if (x >= 6 && x <= 8) {
				for (int i = 3; i <= 5; i++) {
					for (int j = 6; j <= 8; j++) {
						if (y == i && x == j)
							continue;
						if (map[y][x] == map[i][j])
							return false;
					}
				}
			}
		}

		if (y >= 6 && y <= 8) {
			if (x >= 0 && x <= 2) {
				for (int i = 6; i <= 8; i++) {
					for (int j = 0; j <= 2; j++) {
						if (y == i && x == j)
							continue;
						if (map[y][x] == map[i][j])
							return false;
					}
				}
			}

			if (x >= 3 && x <= 5) {
				for (int i = 6; i <= 8; i++) {
					for (int j = 3; j <= 5; j++) {
						if (y == i && x == j)
							continue;
						if (map[y][x] == map[i][j])
							return false;
					}
				}
			}

			if (x >= 6 && x <= 8) {
				for (int i = 6; i <= 8; i++) {
					for (int j = 6; j <= 8; j++) {
						if (y == i && x == j)
							continue;
						if (map[y][x] == map[i][j])
							return false;
					}
				}
			}
		}
		return true;
	}
}
