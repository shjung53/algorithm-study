package 벌꿀채취;

import java.util.*;
import java.io.*;

/**
 * 
 * @author shjung 1. 테스트 케이스 입력 2. 벌통 사이즈, 선택할 수있는 벌통 개수, 채취할 수 있는 최대 꿀의 양 입력 3.
 *         두 꿀벌이 꿀을 선택하는 케이스 모두 탐색
 */
public class Solution {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] map;
	static int size;
	static int maxSelect;
	static int maxHoney;
	static int totalMaxProfit;

	static boolean[] checkHoney;
	static boolean[] visited; // 이익 계산을 위한 방문 배열.
	static int[] startIdx;
	static int[] maxprofitByBee;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			maxSelect = Integer.parseInt(st.nextToken());
			maxHoney = Integer.parseInt(st.nextToken());
			totalMaxProfit = Integer.MIN_VALUE;

			map = new int[size * size];
			int tmpIdx = 0;

			for (int rowIdx = 0; rowIdx < size; rowIdx++) {
				st = new StringTokenizer(br.readLine());
				for (int colIdx = 0; colIdx < size; colIdx++) {
					map[tmpIdx] = Integer.parseInt(st.nextToken());
					tmpIdx++;
				}
			}

			startIdx = new int[2];

			collectHoney(0, 0);

			stb.append('#').append(tc).append(' ').append(totalMaxProfit).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static boolean isDuplicated(int workIdx) {
		int start = startIdx[workIdx];

		for (int i = start; i < start + maxSelect; i++) {
			if (checkHoney[i]) {
				return true;
			} else {
				checkHoney[i] = true;
			}
		}
		return false;
	}

	private static boolean isOverLine(int workIdx) {
		int row = startIdx[workIdx] / size;

		for (int i = 1; i < maxSelect; i++) {
			if ((startIdx[workIdx] + i) / size != row)
				return true;
		}
		return false;
	}

	private static boolean isOverHoney(int workIdx) {
		int sum = 0;
		int start = startIdx[workIdx];
		for (int i = start; i < start + maxSelect; i++) {
			sum += map[i];
		}

		if (sum > maxHoney) {
			return true;
		}

		return false;
	}

	private static void calculateProfit(int selectIdx, int beeIdx) {

		int sumHoney = 0;
		int profit = 0;

		if (selectIdx == maxSelect) {

			for (int i = 0; i < maxSelect; i++) {
				if (visited[i]) {
					int honey = map[i + startIdx[beeIdx]];
					sumHoney += honey;
					profit += honey * honey;
				}
			}

			if (sumHoney <= maxHoney && maxprofitByBee[beeIdx] < profit) {
				maxprofitByBee[beeIdx] = profit;
			}
			return;
		}

		visited[selectIdx] = true;
		calculateProfit(selectIdx + 1, beeIdx);
		visited[selectIdx] = false;
		calculateProfit(selectIdx + 1, beeIdx);
	}

	private static void collectHoney(int honeyIdx, int beeIdx) {

		if (honeyIdx >= size * size)
			return;

		if (beeIdx == 2) {
			maxprofitByBee = new int[2];
			checkHoney = new boolean[size * size];

			for (int workerIdx = 0; workerIdx < 2; workerIdx++) {

				if (isOverLine(workerIdx)) {
					return;
				}
				if (isDuplicated(workerIdx)) {
					return;
				}

				if (isOverHoney(workerIdx)) {
					visited = new boolean[maxSelect];
					calculateProfit(0, workerIdx);
					continue;
				}

				int profit = 0;

				for (int j = 0; j < maxSelect; j++) {
					profit += map[startIdx[workerIdx] + j] * map[startIdx[workerIdx] + j];
				}
				if (maxprofitByBee[workerIdx] < profit)
					maxprofitByBee[workerIdx] = profit;
			}

			if (totalMaxProfit < maxprofitByBee[0] + maxprofitByBee[1])
				totalMaxProfit = maxprofitByBee[0] + maxprofitByBee[1];
			return;
		}

		startIdx[beeIdx] = honeyIdx;
		collectHoney(honeyIdx + 1, beeIdx + 1);
		startIdx[beeIdx] = -1;
		collectHoney(honeyIdx + 1, beeIdx);
	}
}
