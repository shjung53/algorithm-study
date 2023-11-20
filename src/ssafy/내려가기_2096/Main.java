package 내려가기_2096;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] temp;
	static int[] map;
	static int[] maxDp;
	static int[] minDp;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		map = new int[3];
		maxDp = new int[3];
		minDp = new int[3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 3; j++) {
				map[j] = Integer.parseInt(st.nextToken());
				if (i == 0) {
					maxDp[j] = map[j];
					minDp[j] = map[j];
				}
			}

			if (i == 0)
				continue;

			temp = maxDp.clone();
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					maxDp[j] = Math.max(temp[0], temp[1]) + map[j];
				}
				if (j == 1) {
					maxDp[j] = Math.max(temp[0], Math.max(temp[1], temp[2])) + map[j];
				}
				if (j == 2) {
					maxDp[j] = Math.max(temp[1], temp[2]) + map[j];
				}
			}

			temp = minDp.clone();

			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					minDp[j] = Math.min(temp[0], temp[1]) + map[j];
				}
				if (j == 1) {
					minDp[j] = Math.min(temp[0], Math.min(temp[1], temp[2])) + map[j];
				}
				if (j == 2) {
					minDp[j] = Math.min(temp[1], temp[2]) + map[j];
				}
			}
		}

		int max = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]));
		int min = Math.min(minDp[0], Math.min(minDp[1], minDp[2]));
		System.out.println(max);
		System.out.println(min);
	}
}
