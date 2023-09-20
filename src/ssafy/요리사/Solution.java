package 요리사;

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] foodSynergy;
	static int[] foodCombi;
	static int foodCount;
	static int aSynergy;
	static int bSynergy;
	static int minGap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder stb = new StringBuilder();
		br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc < testCase + 1; tc++) {
			foodCount = Integer.parseInt(br.readLine().trim());
			foodSynergy = new int[foodCount][foodCount];
			foodCombi = new int[foodCount];
			minGap = Integer.MAX_VALUE;

			for (int rowIdx = 0; rowIdx < foodCount; rowIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int colIdx = 0; colIdx < foodCount; colIdx++) {
					foodSynergy[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				}
			}

			selectAorB(0, 0);

			stb.append('#').append(tc).append(' ').append(minGap).append('\n');
		}
		System.out.println(stb.toString());
	}

	// 재료 배열을 돌면서 1번 요리재료 체크하고 1번 요리 카운트를 +1 하거나 0번 요리인 경우 다음 인덱스로 넘어가기
	private static void selectAorB(int foodIdx, int aCount) {
		if (aCount == foodCount / 2) {
			getSynergyGap();
			return;
		}

		if (foodIdx >= foodCount)
			return;

		// 1번 요리에 재료가 절반 이상 들어가면 return
		if (aCount > foodCount / 2) {
			return;
		}

		foodCombi[foodIdx] = 1;
		selectAorB(foodIdx + 1, aCount + 1);
		foodCombi[foodIdx] = 0;
		selectAorB(foodIdx + 1, aCount);
	}

	// 시너지 합 구하기
	private static void getSynergyGap() {
		aSynergy = 0;
		bSynergy = 0;

		for (int rowIdx = 0; rowIdx < foodCount; rowIdx++) {
			for (int colIdx = 0; colIdx < foodCount; colIdx++) {
				if (foodCombi[rowIdx] == 1 && foodCombi[colIdx] == 1)
					aSynergy += foodSynergy[rowIdx][colIdx];

				if (foodCombi[rowIdx] == 0 && foodCombi[colIdx] == 0)
					bSynergy += foodSynergy[rowIdx][colIdx];
			}
		}

		int gap = Math.abs(aSynergy - bSynergy);
		if (minGap > gap)
			minGap = gap;
	}
}
