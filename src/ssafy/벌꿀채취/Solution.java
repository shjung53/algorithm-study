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
	static int[][] beeHive;
	static int beeHiveSize;
	static int maxSelect;
	static int maxHoney;
	static int maxProfit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			beeHiveSize = Integer.parseInt(st.nextToken());
			maxSelect = Integer.parseInt(st.nextToken());
			maxHoney = Integer.parseInt(st.nextToken());
			maxProfit = Integer.MIN_VALUE;

			beeHive = new int[beeHiveSize][beeHiveSize];

			for (int rowIdx = 0; rowIdx < beeHiveSize; rowIdx++) {
				st = new StringTokenizer(br.readLine());
				for (int colIdx = 0; colIdx < beeHiveSize; colIdx++) {
					beeHive[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				}
			}

			beeSelect();
			System.out.println(maxProfit);

		}
	}

	private static void beeSelect() {
		for (int rowIdx = 0; rowIdx < beeHiveSize; rowIdx++) {
			for (int colIdx = 0; colIdx < beeHiveSize - maxSelect + 1; colIdx++) {
				firstBee(rowIdx, colIdx, (int) Math.pow(beeHive[rowIdx][colIdx], 2), 1, beeHive[rowIdx][colIdx]);
			}
		}
	}

	private static void firstBee(int y, int x, int profit, int count, int sum) {
		if (count == maxSelect || sum + beeHive[y][x + 1] > sum) {
			secondBeeSelect(y, x + 1, profit);
			return;
		}

		firstBee(y, x + 1, profit + (int) Math.pow(beeHive[y][x + 1], 2), count + 1, sum + beeHive[y][x + 1]);

	}

	private static void secondBeeSelect(int element1, int element2, int firstProfit) {
		if (element2 > beeHiveSize - maxSelect) {
			element1++;
			element2 = 0;
		}
		for (int rowIdx = element1; rowIdx < beeHiveSize - maxSelect; rowIdx++) {
			for (int colIdx = element2; colIdx < beeHiveSize - maxSelect + 1; colIdx++) {
				secondBee(rowIdx, colIdx, (int) Math.pow(beeHive[rowIdx][colIdx], 2), 1, beeHive[rowIdx][colIdx],
						firstProfit);
			}
		}
	}

	private static void secondBee(int y, int x, int profit, int count, int sum, int firstProfit) {
		if (count == maxSelect || sum + beeHive[y][x + 1] > sum) {
			if (maxProfit < firstProfit + profit)
				maxProfit = firstProfit + profit;
			return;
		}

		secondBee(y, x + 1, profit + (int) Math.pow(beeHive[y][x + 1], 2), count + 1, sum + beeHive[y][x + 1],
				firstProfit);
	}
}
