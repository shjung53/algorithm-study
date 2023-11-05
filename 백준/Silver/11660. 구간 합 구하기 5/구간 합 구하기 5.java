import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] graph;
	static int[][] dp;
	static int n;
	static int m;
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			findDp(i, n);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			sum = 0;

			for (int x = startX; x <= endX; x++) {
				sum += dp[x][endY] - dp[x][startY-1];
			}

			stb.append(sum).append('\n');
		}

		System.out.println(stb);
	}

	public static int findDp(int x, int y) {
		if (y == 1)
			return dp[x][y] = graph[x][y];
		return dp[x][y] = findDp(x, y - 1) + graph[x][y];
	}

}
