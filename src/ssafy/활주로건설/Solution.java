package 활주로건설;

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int x;
	static int count;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		StringBuilder stb = new StringBuilder();

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			count = 0;

			for (int i = 0; i < n; i++) {
				checkRow(i);
				checkCol(i);
			}

			stb.append('#').append(tc).append(' ').append(count).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static void checkRow(int rowIdx) {
		int preHeight = -1;
		int flat = 0; // 평지
		for (int colIdx = 0; colIdx < n; colIdx++) {
			// 첫 땅
			if (preHeight == -1) {
				preHeight = map[rowIdx][colIdx];
				flat++;
				continue;
			}

			// 이전과 높이가 같으면 평평한 길이 ++
			if (map[rowIdx][colIdx] == preHeight) {
				flat++;
				if (colIdx == n - 1) {
					if (flat >= 0)
						count++;
				}
			} else {
				// 현재 땅이 이전 땅보다 높은 경우
				if (map[rowIdx][colIdx] > preHeight) {
					// 마지막 인덱스에서 높아지지만 앞에 x만큼 평지가 있을 경우는 count
					if (colIdx == n - 1) {
						if (flat >= x)
							count++;
					}
					// 차이가 1보다 크면 X
					if (map[rowIdx][colIdx] - preHeight > 1)
						break;
					// 평평한 땅이 x보다 짧으면 X
					if (flat < x)
						break;
					// 높이랑 평평한 길이 초기화
					preHeight = map[rowIdx][colIdx];
					flat = 1;
				} else {
					// 현재 땅이 이전 땅보다 낮은 경우
					if (preHeight - map[rowIdx][colIdx] > 1)
						break;
					// 낮아질때 필요한 평지 확보 못하면 끝
					if (flat < 0)
						break;
					// 높이랑 평평한 길이 초기화, 낮아지는 경우 뒤에도 평평한 땅 필요
					preHeight = map[rowIdx][colIdx];
					flat = 1 - x;
				}
			}
		}
	}

	private static void checkCol(int colIdx) {
		int preHeight = -1;
		int flat = 0;
		for (int rowIdx = 0; rowIdx < n; rowIdx++) {
			// 첫 땅
			if (preHeight == -1) {
				preHeight = map[rowIdx][colIdx];
				flat++;
				continue;
			}

			// 이전과 높이가 같으면 평평한 길이 ++
			if (map[rowIdx][colIdx] == preHeight) {
				flat++;
				if (rowIdx == n - 1) {
					if (flat >= 0)
						count++;
				}
			} else {
				// 현재 땅이 이전 땅보다 높은 경우
				if (map[rowIdx][colIdx] > preHeight) {
					// 마지막 인덱스에서 높아지지만 앞에 x만큼 평지가 있을 경우는 count
					if (rowIdx == n - 1) {
						if (flat >= x)
							count++;
					}
					// 차이가 1보다 크면 X
					if (map[rowIdx][colIdx] - preHeight > 1)
						break;
					// 평평한 땅이 x보다 짧으면 X
					if (flat < x)
						break;
					// 높이랑 평평한 길이 초기화
					preHeight = map[rowIdx][colIdx];
					flat = 1;
				} else {
					// 현재 땅이 이전 땅보다 낮은 경우
					if (preHeight - map[rowIdx][colIdx] > 1)
						break;
					// 낮아질때 필요한 평지 확보 못하면 끝
					if (flat < 0)
						break;
					// 높이랑 평평한 길이 초기화, 낮아지는 경우 뒤에도 평평한 땅 필요
					preHeight = map[rowIdx][colIdx];
					flat = 1 - x;
				}
			}
		}
	}
}
