package 보급로;

import java.util.*;
import java.io.*;

public class Solution {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int n;
	static int[][] board;
	static int[][] record;
	static int answer;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			record = new int[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					board[i][j] = Character.getNumericValue(str.charAt(j));
				}
			}
			answer = Integer.MAX_VALUE;
			bfs();

			stb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static void bfs() {

		Queue<Location> queue = new ArrayDeque<>();
		Set<Location> set = new HashSet<>();

		Location start = new Location(0, 0);
		queue.offer(start);
		set.add(start);

		while (!queue.isEmpty()) {
			int queueSize = queue.size();

			for (int i = 0; i < queueSize; i++) {
				Location now = queue.poll();
				int nowY = now.y;
				int nowX = now.x;

				if (now.count > record[now.y][now.x])
					continue;

				if (nowY == n - 1 && nowX == n - 1) {
					if (now.count < answer)
						answer = now.count;
					continue;
				}

				for (int j = 0; j < 4; j++) {
					int newY = nowY + dy[j];
					int newX = nowX + dx[j];

					if (newY < 0 || newY >= n || newX < 0 || newX >= n)
						continue;

					Location next = new Location(newY, newX);
					next.count = now.count + board[newY][newX];
					if (set.contains(next)) {
						if (record[newY][newX] > next.count) {
							record[newY][newX] = next.count;
							queue.offer(next);
						}
					} else {
						record[newY][newX] = next.count;
						set.add(next);
						queue.offer(next);
					}
				}
			}
		}
	}
}

class Location {
	int y;
	int x;
	int count;

	public Location(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
