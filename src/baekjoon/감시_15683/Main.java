package 감시_15683;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int[][] map;
	static ArrayList<CCTV> cctvs;
	static int cctvMax;
	static int answer;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		cctvs = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6)
					cctvs.add(new CCTV(i, j));
			}
		}

		answer = Integer.MAX_VALUE;
		cctvMax = cctvs.size();

		int cctvIdx = 0;

		setDir(cctvIdx);

		System.out.println(answer);

	}

	private static void setDir(int cctvIdx) {

		if (cctvIdx == cctvMax) {
			int count = count();
			if (answer > count)
				answer = count;
			return;
		}

		int nowY = cctvs.get(cctvIdx).y;
		int nowX = cctvs.get(cctvIdx).x;
		int[][] backUp;

		switch (map[nowY][nowX]) {
		case 1:
			for (int dir = 0; dir < 4; dir++) {
				backUp = cloneMap();
				overWatch(nowY, nowX, dir);
				setDir(cctvIdx + 1);
				map = backUp;
			}
			break;
		case 2:
			for (int dir = 0; dir < 2; dir++) {
				backUp = cloneMap();
				overWatch(nowY, nowX, dir);
				overWatch(nowY, nowX, dir + 2);
				setDir(cctvIdx + 1);
				map = backUp;
			}
			break;
		case 3:
			for (int dir = 0; dir < 4; dir++) {
				backUp = cloneMap();
				overWatch(nowY, nowX, dir % 4);
				overWatch(nowY, nowX, (dir + 1) % 4);
				setDir(cctvIdx + 1);
				map = backUp;
			}
			break;
		case 4:
			for (int dir = 0; dir < 4; dir++) {
				backUp = cloneMap();
				overWatch(nowY, nowX, dir % 4);
				overWatch(nowY, nowX, (dir + 1) % 4);
				overWatch(nowY, nowX, (dir + 2) % 4);
				setDir(cctvIdx + 1);
				map = backUp;
			}
			break;
		case 5:
			backUp = cloneMap();
			overWatch(nowY, nowX, 0);
			overWatch(nowY, nowX, 1);
			overWatch(nowY, nowX, 2);
			overWatch(nowY, nowX, 3);
			setDir(cctvIdx + 1);
			reset(nowY, nowX, 0);
			reset(nowY, nowX, 1);
			reset(nowY, nowX, 2);
			reset(nowY, nowX, 3);
		}
	}

	private static int count() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}

		return count;
	}

	// 정한 방향으로 감시구역 세팅
	private static void overWatch(int y, int x, int dir) {

		if (map[y][x] == 6)
			return;
		if (map[y][x] == 0)
			map[y][x] = -1;
		int newY = y + dy[dir];
		int newX = x + dx[dir];
		if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
			return;
		} else {
			overWatch(newY, newX, dir);
		}
	}

	private static void reset(int y, int x, int dir) {
		if (map[y][x] == 6)
			return;
		if (map[y][x] == -1)
			map[y][x] = 0;
		int newY = y + dy[dir];
		int newX = x + dx[dir];
		if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
			return;
		} else {
			reset(newY, newX, dir);
		}
	}

	private static int[][] cloneMap() {
		int[][] clone = new int[n][m];
		for (int i = 0; i < n; i++) {
			clone[i] = map[i].clone();
		}
		return clone;
	}
}

class CCTV {
	int y;
	int x;

	public CCTV(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

}
