import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map; // 0은 빈칸, 1은 뱀, 2는 사과
	static int[] dy = { 0, 1, 0, -1 }; // direction이 +1 이면 오른쪽으로 90도 +3하고 4로 나눈 나머지면 왼쪽으로 90도
	static int[] dx = { 1, 0, -1, 0 };
	static int n, k, l, direction;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n + 1][n + 1];
		ArrayDeque<Position> snake = new ArrayDeque<>(); // first가 머리 last가 꼬리
		HashMap<Integer, String> changeDirection = new HashMap<Integer, String>();
		k = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y][x] = 2;
		}

		l = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int changeSecond = Integer.parseInt(st.nextToken());
			String change = st.nextToken();
			changeDirection.put(changeSecond, change);
		}

		int second = 0;
		map[1][1] = 1;
		snake.addFirst(new Position(1, 1));
		direction = 0;

		while (true) {
			second++;
			int newY = snake.getFirst().y + dy[direction];
			int newX = snake.getFirst().x + dx[direction];

			if (newY < 1 || newX < 1 || newY > n || newX > n || map[newY][newX] == 1)
				break; // 벽에 부딪히거나 자기 몸에 부딪히면 끝

			// 만약 사과가 있으면 꼬리는 가만히 있고 몸이 늘어나고 머리만 이동하게 된다.
			snake.addFirst(new Position(newY, newX));
			if (map[newY][newX] != 2) {
				Position tail = snake.removeLast();
				map[tail.y][tail.x] = 0;
			}
			map[newY][newX] = 1;

			if ("D".equals(changeDirection.get(second))) {
				direction = (direction + 1) % 4;
			}

			if ("L".equals(changeDirection.get(second))) {
				direction = (direction + 3) % 4;
			}

		}

		System.out.println(second);

	}
}

class Position {
	int y, x;

	public Position(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
