package 숫자판점프_2210;

import java.util.*;
import java.io.*;

public class Main {
	static int[][] board = new int[5][5];
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
//		중복제거를 위한 set
		Set<Integer> set = new HashSet<>();
		int level = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				queue.offer(new Point(i, j, board[i][j]));
			}
		}
		level++;

		while (!queue.isEmpty()) {
			if (level == 6)
				break;
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				Point nowP = queue.poll();
				for (int j = 0; j < 4; j++) {
					int newY = nowP.y + dy[j];
					int newX = nowP.x + dx[j];
					if (!check(newY, newX))
						continue;
//					다음 숫자는 이전 숫자를 10 곱하고 다음 위치의 숫자 +
					int nextNum = (int) (10 * nowP.num + board[newY][newX]);
//					level 5일때 더하면 6자리가 완성
					if (level == 5)
						set.add(nextNum);
					queue.offer(new Point(newY, newX, nextNum));
				}
			}
			level++;
		}
		System.out.println(set.size());
	}

	private static boolean check(int i, int j) {
		if (i < 0 || i >= 5 || j < 0 || j >= 5)
			return false;
		return true;
	}
}

class Point {
	int y;
	int x;
	int num;

	public Point(int y, int x, int num) {
		super();
		this.y = y;
		this.x = x;
		this.num = num;
	}

}
