package Flatten;

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int answer = 0;
			int[] boxArr = new int[100];
			int dumpLimit = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			int avg = 0;
			int remain = 0;
			for (int i = 0; i < 100; i++) {
				int boxes = Integer.parseInt(st.nextToken());
				boxArr[i] = boxes;
				sum += boxes;
			}

			for (int i = 0; i < dumpLimit; i++) {
				int[] minMax = findMinMax(boxArr);
				boxArr[minMax[0]]++;
				boxArr[minMax[1]]--;
			}

			int[] minMax = findMinMax(boxArr);
			answer = boxArr[minMax[1]] - boxArr[minMax[0]];
			System.out.println(String.format("#%d %d", test_case, answer));
		}
	}

	private static int[] findMinMax(int[] arr) {
		int max = 0;
		int min = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[max])
				max = i;
			if (arr[i] < arr[min])
				min = i;
		}
		return new int[] { min, max };
	}
}