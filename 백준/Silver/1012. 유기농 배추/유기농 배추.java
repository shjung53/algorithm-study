import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int[][] map;
	static int count, n, m, k;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine().trim());
		StringBuilder stb = new StringBuilder();

		for (int testCase = 0; testCase < test; testCase++) {
			st = new StringTokenizer(br.readLine().trim());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			count = 0;

			map = new int[n][m];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int colIdx = Integer.parseInt(st.nextToken());
				int rowIdx = Integer.parseInt(st.nextToken());
				map[rowIdx][colIdx] = 1;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}

			System.out.println(count);
		}
	}

	private static void bfs(int y, int x) {
		Queue<Position> queue = new ArrayDeque<>();

		map[y][x] = 0;
		queue.offer(new Position(y, x));

		while (!queue.isEmpty()) {
			Position now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int newY = now.y + dy[i];
				int newX = now.x + dx[i];

				if (newY < 0 || newY >= n || newX < 0 || newX >= m)
					continue;

				if (map[newY][newX] == 0)
					continue;

				map[newY][newX] = 0;
				queue.offer(new Position(newY, newX));
			}
		}
	}
}

class Position {
	int y, x;

	public Position(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

}
