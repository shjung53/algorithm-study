package 창용마을무리의개수;

import java.util.*;
import java.io.*;

public class Solution {
	static int[][] connection;
	static boolean[] visited;
	static int n;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			answer = 0;
			connection = new int[n + 1][n + 1];
			visited = new boolean[n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				connection[from][to] = 1;
				connection[to][from] = 1;
			}

			for (int i = 1; i < n + 1; i++) {
				if (!visited[i]) {
					answer++;
					dfs(i);
				}
			}

			stb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static void dfs(int man) {
		for (int i = 1; i <= n; i++) {
			if (connection[man][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
}
