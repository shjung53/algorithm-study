package 사회망서비스_2533;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static ArrayList<Integer>[] links;
	static int[][] dp;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		dp = new int[n + 1][2]; // 1부터 n번노드까지 1은 얼리어답터일때, 0은 얼리어답터가 아닐 때
		links = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			links[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			links[node1].add(node2);
			links[node2].add(node1);
		}

		// 루트는 마음대로 두어도 상관 없다.
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));

	}

	private static void dfs(int num) {
		visited[num] = true;
		dp[num][0] = 0; // 1번 노드가 얼리어답터가 아닐때
		dp[num][1] = 1; // 1번 노드가 얼리어답터 일 때

		for (int child : links[num]) {
			if (visited[child])
				continue;
			dfs(child); // 연결된 자식의 값 구하기
			dp[num][0] += dp[child][1]; // 현재 노드가 얼리어답터가 아니면 자식은 얼리어답터여야 한다.
			dp[num][1] += Math.min(dp[child][0], dp[child][1]); // 현재 노드가 얼리어답터이면 자식은 얼리어답터일수도 아닐수도 있다. 최솟값으로 구한다.
		}
	}
}
