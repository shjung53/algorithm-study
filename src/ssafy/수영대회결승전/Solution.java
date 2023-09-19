package 수영대회결승전;

import java.io.*;
import java.util.*;

/**
 * 
 * @author shjung
 *
 *         1. 테스트 케이스 개수 입력받기 2. 테스트 케이스마다 정사각형 바다 한 변의 길이와 바다 구성요소 입력받고 출발점,
 *         도착점 및 시간과 방문배열 초기화 3. 모든 경로를 탐색해서 가장 짧은 시간 구하기 4. 시간을 구현하여 소용돌이 생성과
 *         소멸 구현하기
 */

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;

	// 수영할 수 있는 상하좌우
	static int[] directionY = { 0, 1, 0, -1 };
	static int[] directionX = { 1, 0, -1, 0 };

	// 바다 배열
	// 바다의 왼쪽위에서 오른쪽 아래로 0,0 ~ n,n
	static int[][] sea;

	// 방문 시간
	static int[][] visited;

	// 바다 한변의 길이
	static int seaSideLength;

	// 시간
	static int time;

	// 출발점
	// 세로가 Y, 가로가 X
	static int startY;
	static int startX;

	// 도착점
	static int destinationY;
	static int destinationX;

	// 가장 짧은 정답시간
	static int minTime;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		// 1. 테스트 케이스 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc < testCase + 1; tc++) {

			// 2. 테스트 케이스마다 한변의 길이 입력받고 요소들 초기화
			seaSideLength = Integer.parseInt(br.readLine().trim());
			sea = new int[seaSideLength][seaSideLength];
			visited = new int[seaSideLength][seaSideLength];
			time = 0;
			minTime = Integer.MAX_VALUE;

			// 바다 구성요소 입력받기
			for (int rowNum = 0; rowNum < seaSideLength; rowNum++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int colNum = 0; colNum < seaSideLength; colNum++) {
					sea[rowNum][colNum] = Integer.parseInt(st.nextToken());
					visited[rowNum][colNum] = Integer.MAX_VALUE;
				}
			}

			// 출발 및 도착점 입력받기
			st = new StringTokenizer(br.readLine().trim());
			startY = Integer.parseInt(st.nextToken());
			startX = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine().trim());
			destinationY = Integer.parseInt(st.nextToken());
			destinationX = Integer.parseInt(st.nextToken());

			// 3. 모든 경로를 탐색해서 가장 짧은 시간 구하기
			visited[startY][startX] = 0;
			dfs(startY, startX);

			if (minTime == Integer.MAX_VALUE) {
				minTime = -1;
			}

			stb.append('#').append(tc).append(' ').append(minTime).append('\n');
		}
		System.out.println(stb.toString());
	}

	public static void dfs(int y, int x) {
		if (visited[y][x] < time) {
			return;
		} else {
			visited[y][x] = time;
		}

		// 도착지에 도착했으면 시간확인해서 작으면 최소 시간 업데이트하고 탐색 종료
		if (y == destinationY && x == destinationX) {
			if (visited[y][x] > time) {
				visited[y][x] = time;
			}

			if (time < minTime) {
				minTime = time;
			}
			return;
		}

		// 현재 위치에서 갈 수 있는 다음 위치 확인하기
		for (int rotateIdx = 0; rotateIdx < directionY.length; rotateIdx++) {
			// 다음 위치 좌표 생성
			int nextY = y + directionY[rotateIdx];
			int nextX = x + directionX[rotateIdx];

			// 다음 좌표 이동가능한지 확인
			if (nextY < 0 || nextY >= seaSideLength || nextX < 0 || nextX >= seaSideLength || sea[nextY][nextX] == 1)
				continue;

			// 다음 좌표에 소용돌이가 있으면 소용돌이를 기다렸다가 건너야 하기 때문에 기다려야 하는 시간을 추가
			if (sea[nextY][nextX] == 2) {
				// 소용돌이인 경우 3가지 경우로 나뉨
				// 경로 탐색 후 돌아와서 더해준 시간 복구 <백트래킹>
				if (time % 3 == 1) {
					time += 2;
					dfs(nextY, nextX);
					time -= 2;
				} else if (time % 3 == 0) {
					time += 3;
					dfs(nextY, nextX);
					time -= 3;
				} else {
					time++;
					dfs(nextY, nextX);
					time--;
				}
			} else {
				time++;
				dfs(nextY, nextX);
				time--;
			}
		}

	}
}
