package 최빈수;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int testNum = Integer.parseInt(bf.readLine());
			int[] scoreBoard = new int[101];
			int maxScore = -1;
			StringTokenizer st = new StringTokenizer(bf.readLine());

			for (int i = 0; i < 1000; i++) {
				int score = Integer.parseInt(st.nextToken());
				scoreBoard[score]++;
				if (maxScore < 0) {
					maxScore = score;
					continue;
				}
				if (scoreBoard[score] > scoreBoard[maxScore]) {
					maxScore = score;
				}

				if (scoreBoard[score] == scoreBoard[maxScore]) {
					maxScore = Math.max(score, maxScore);
				}
			}
			System.out.println(String.format("#%d %d", testNum, maxScore));
		}
	}
}
