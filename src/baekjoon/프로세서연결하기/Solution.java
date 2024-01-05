package 프로세서연결하기;

import java.util.*;
import java.io.*;

public class Solution {

	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int minLine;
	static int maxPro;
	static int[][] board;
	// 0은 빈칸, 1은 프로세서, 2는 전선, 3은 체크된 프로세서
	static int[][] visited;
	static ArrayList<Point> arr;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		StringBuilder stb = new StringBuilder();

		for (int tc = 1; tc <= testCase; tc++) {
			n = Integer.parseInt(br.readLine().trim());
			board = new int[n][n];
			visited = new int[n][n];
			maxPro = Integer.MIN_VALUE;
			minLine = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					visited[i][j] = board[i][j];
				}
			}

			checkSide();
			arr = new ArrayList<Point>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] == 1) {
						arr.add(new Point(i, j));
					}
				}
			}

			connect(0, 0, 0);

//			stb.append('#').append(tc).append(' ').append(minLine).append('\n');
			System.out.println("#" + tc + " " + minLine);
		}
//		System.out.println(stb.toString());
	}

	// 방향으로 벽까지 체크하고 연결시도
	private static void connect(int index, int coreCnt, int lineCnt) {
		if (index >= arr.size()) {
			checkLine(coreCnt, lineCnt);
			return;
		}

//		if (coreCnt + arr.size() - index < maxPro)
//			return;

		Point processor = arr.get(index);
		int y = processor.y;
		int x = processor.x;

		for (int dir = 0; dir < 4; dir++) {
			boolean fail = false;
			int nextY = y + dy[dir];
			int nextX = x + dx[dir];

			// 벽을 만날때까지 전선 연결
			while (nextY != 0 && nextX != 0 && nextY != n - 1 && nextX != n - 1 && visited[nextY][nextX] == 0) {
				lineCnt++;
				visited[nextY][nextX] = 2;
				nextY += dy[dir];
				nextX += dx[dir];
			}

			// 벽을 만났을때 마지막에 장애물이 없으면 성공
			if ((nextY == 0 || nextX == 0 || nextY == n - 1 || nextX == n - 1) && visited[nextY][nextX] == 0) {
				visited[nextY][nextX] = 2;
				visited[y][x] = 3;
				coreCnt++;
				lineCnt++;
			} else {
				// 연결 실패하면 리셋
				fail = true;
				visited[y][x] = 1;
				lineCnt -= reset(dir, y, x, nextY, nextX);
			}

			// 다음 프로세서 연결하러 가기
			connect(index + 1, coreCnt, lineCnt);

			// 실패하면 리셋 안해도 리셋되어 있음
			if (!fail) {
				// 다른 전선 연결해보기 위해 리셋
				visited[nextY][nextX] = 0;
				visited[y][x] = 1;
				lineCnt -= reset(dir, y, x, nextY, nextX);
				lineCnt--;
				coreCnt--;
			}
		}
	}

	private static void checkLine(int coreCnt, int lineCnt) {
		if (maxPro < coreCnt) {
			maxPro = coreCnt;
			minLine = lineCnt;
		} else if (maxPro == coreCnt) {
			if (minLine > lineCnt)
				minLine = lineCnt;
		}
	}

	private static int reset(int dir, int oY, int oX, int y, int x) {
		int lineCnt = 0;
		if (dir == 0) {
			for (int i = y + 1; i < oY; i++) {
				visited[i][x] = 0;
				lineCnt++;
			}
		} else if (dir == 1) {
			for (int i = oX + 1; i < x; i++) {
				visited[y][i] = 0;
				lineCnt++;
			}
		} else if (dir == 2) {
			for (int i = oY + 1; i < y; i++) {
				visited[i][x] = 0;
				lineCnt++;
			}
		} else {
			for (int i = x + 1; i < oX; i++) {
				visited[y][i] = 0;
				lineCnt++;
			}
		}

		return lineCnt;
	}

	// 벽에 붙은 프로세서 체크
	private static void checkSide() {
		for (int i = 0; i < n; i++) {
			if (board[i][0] == 1 && visited[i][0] == 1) {
				visited[i][0] = 3;
			}
			if (board[0][i] == 1 && visited[0][i] == 1) {
				visited[0][i] = 3;
			}
			if (board[n - 1][i] == 1 && visited[n - 1][i] == 1) {
				visited[n - 1][i] = 3;
			}
			if (board[i][n - 1] == 1 && visited[i][n - 1] == 1) {
				visited[i][n - 1] = 3;
			}
		}
	}
}

class Point {
	int y;
	int x;

	public Point(int y, int x) {
		super();
		this.x = x;
		this.y = y;
	}

}
