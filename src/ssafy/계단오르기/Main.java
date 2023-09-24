package 계단오르기;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int stairCount = Integer.parseInt(br.readLine().trim());

		int[] stairArr = new int[stairCount];
		int[] point = new int[stairCount];

		for (int i = 0; i < stairCount; i++) {
			stairArr[i] = Integer.parseInt(br.readLine().trim());
		}

		for (int i = stairCount - 1; i >= 2; i--) {
			point[i] = Math.max(point[i - 1] + stairArr[i], point[i - 2] + stairArr[i]);
		}

		System.out.println(point[point.length - 1]);

	}
}
