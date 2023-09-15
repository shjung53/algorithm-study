package 최적경로;

import java.util.*;
import java.io.*;

public class Solution {
	static boolean[] visited;
	static int n;
	static int count;
	static int distance;
	static int[] arrX;
	static int[] arrY;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder stb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			count = 0;
			distance = 0;
			visited = new boolean[n + 2];
			arrX = new int[n + 2];
			arrY = new int[n + 2];
			answer = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n + 2; i++) {
				arrX[i] = Integer.parseInt(st.nextToken());
				arrY[i] = Integer.parseInt(st.nextToken());
			}

			dfs(arrX[0], arrY[0]);

			stb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static void dfs(int x, int y) {
		if (count == n) {
			distance += Math.abs(x - arrX[1]) + Math.abs(y - arrY[1]);
			if (distance < answer)
				answer = distance;
			distance -= Math.abs(x - arrX[1]) + Math.abs(y - arrY[1]);
			return;
		}

		for (int i = 2; i < n + 2; i++) {
			if (!visited[i]) {
				distance += Math.abs(x - arrX[i]) + Math.abs(y - arrY[i]);
				visited[i] = true;
				count++;
				dfs(arrX[i], arrY[i]);
				distance -= Math.abs(x - arrX[i]) + Math.abs(y - arrY[i]);
				visited[i] = false;
				count--;
			}
		}
	}
}
