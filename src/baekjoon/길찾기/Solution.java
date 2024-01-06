package 길찾기;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int testNum = Integer.parseInt(st.nextToken());
			int routeCount = Integer.parseInt(st.nextToken());

			int[] route1 = new int[100];
			int[] route2 = new int[100];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < routeCount; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				if (route1[from] == 0) {
					route1[from] = to;
				} else {
					route2[from] = to;
				}
			}

			int answer = findRoute(route1, route2, 0);

			System.out.println("#" + testNum + " " + answer);

		}
	}

	private static int findRoute(int[] route1, int[] route2, int nowPos) {
		if (nowPos == 99) {
			return 1;
		}

		if (route1[nowPos] != 0) {
			int movePos = route1[nowPos];
			route1[nowPos] = 0;
			if (findRoute(route1, route2, movePos) == 1)
				return 1;
		}
		if (route2[nowPos] != 0) {
			int movePos = route2[nowPos];
			route2[nowPos] = 0;

			if (findRoute(route1, route2, movePos) == 1)
				return 1;
		}
		return 0;
	}
}
