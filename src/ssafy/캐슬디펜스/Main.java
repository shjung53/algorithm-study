package 캐슬디펜스;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int[][] map;
	static int[][] cloneMap;
	static int range;
	static int count;
	static int maxCount;
	static int rangerCount; // 궁수 배치 숫자
	static boolean[][] shot; // 화살 맞았는지 확인

	static int[] dy = { 0, -1, 0 };
	static int[] dx = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 성벽 표시
		for (int j = 0; j < m; j++) {
			map[n][j] = 2;
		}

		rangerCount = 0;

		maxCount = 0;

		setRanger(0);

		System.out.println(maxCount);

	}

	// 성벽라인에서 궁수 3곳 배치
	private static void setRanger(int idx) {
		if (idx == m) {
			// 3명 다 배치 못하고 idx 초과
			if (rangerCount < 3)
				return;
		}
		if (rangerCount == 3) {
			// 궁수 3명 배치 완료
			count = 0;
			// 적이 맵에 존재하면 계속 진행

			cloneMap = cloneMap();

			while (!noEnemy()) {
				shot = new boolean[n][m];
				for (int i = 0; i < m; i++) {
					// 궁수를 찾고 가장 가까운 적 찾아서 표시하기
					if (cloneMap[n][i] == 3) {
						bfs(n, i);
					}
				}
				deleteEnemy();
				moveEnemy();
			}
			if (maxCount < count)
				maxCount = count;
			return;
		}

		map[n][idx] = 3;
		rangerCount++;
		setRanger(idx + 1);
		rangerCount--;
		map[n][idx] = 2;
		setRanger(idx + 1);
	}

	private static int[][] cloneMap() {
		int[][] clone = new int[n + 1][m];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m; j++) {
				clone[i][j] = map[i][j];
			}
		}
		return clone;
	}

	private static void moveEnemy() {
		// 중복 이동 방지를 위해 아래서부터 적 이동
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if (cloneMap[i][j] == 1) {
					cloneMap[i][j] = 0;
					if (i + 1 == n) {
						continue;
					}
					cloneMap[i + 1][j] = 1;
				}
			}
		}
	}

	// 적 삭제
	private static void deleteEnemy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (shot[i][j]) {
					count++;
					cloneMap[i][j] = 0;
				}
			}
		}
	}

	private static void bfs(int y, int x) {
		Queue<Location> queue = new ArrayDeque<Location>();

		queue.offer(new Location(y, x, 0));
		boolean[][] visited = new boolean[n + 1][m];

		while (!queue.isEmpty()) {
			Location now = queue.poll();
			// 사거리 벗어났으면 체크 안함
			if (now.dis > range)
				break;
			int nowY = now.y;
			int nowX = now.x;
			// 적 찾으면 탈출
			if (cloneMap[nowY][nowX] == 1) {
				shot[nowY][nowX] = true;
				break;
			}
			// 왼쪽, 위 , 오른쪽 순으로 이동하면서 적 찾기
			for (int i = 0; i < 3; i++) {
				int newY = now.y + dy[i];
				int newX = now.x + dx[i];
				if (newY < 0 || newX < 0 || newY >= n || newX >= m || visited[newY][newX])
					continue;
				visited[newY][newX] = true;
				queue.offer(new Location(newY, newX, now.dis + 1));
			}
		}
	}

	// 적이 없으면 true
	private static boolean noEnemy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cloneMap[i][j] == 1)
					return false;
			}
		}
		return true;
	}
}

class Location {
	int y;
	int x;
	int dis;

	public Location(int y, int x, int dis) {
		super();
		this.y = y;
		this.x = x;
		this.dis = dis;
	}

}
