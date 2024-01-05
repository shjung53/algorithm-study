package View;

import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int answerCnt = 0;
			int buildingNum = Integer.parseInt(br.readLine());
			int[] heightArr = new int[buildingNum];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < buildingNum; i++) {
				int height = Integer.parseInt(st.nextToken());
				heightArr[i] = height;
			}
			for (int i = 0; i < buildingNum; i++) {
				int height = heightArr[i];
				int maxAround = 0;
				if (height == 0)
					continue;
				maxAround = Math.max(heightArr[i - 2], heightArr[i - 1]);
				maxAround = Math.max(maxAround, heightArr[i + 1]);
				maxAround = Math.max(maxAround, heightArr[i + 2]);
				if (height > maxAround)
					answerCnt += (height - maxAround);
			}
			System.out.println(String.format("#%d %d", test_case, answerCnt));
		}
	}
}