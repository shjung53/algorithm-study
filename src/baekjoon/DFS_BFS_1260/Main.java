package DFS_BFS_1260;

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder stb;
	static int[][] connection;
	static boolean[] visited;
	static int n; // 정점의 개수
	static int m; // 간선의 개수
	static int v; // 탐색시작 정점 번호

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		stb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		connection = new int[n + 1][n + 1]; // 1부터 n까지 정점이 존재하고 이에 대한 관계

		for (int inputIdx = 0; inputIdx < m; inputIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			connection[vertex1][vertex2] = 1;
			connection[vertex2][vertex1] = 1;
		}

		visited = new boolean[n + 1];
		dfs(v);
		stb.deleteCharAt(stb.length() - 1).append('\n');
		visited = new boolean[n + 1];
		bfs(v);
		stb.deleteCharAt(stb.length() - 1);
		System.out.println(stb.toString());
	}

	static void dfs(int nowIdx) {
		visited[nowIdx] = true;
		stb.append(nowIdx).append(' ');
		for (int findIdx = 1; findIdx <= n; findIdx++) {
			if (connection[findIdx][nowIdx] == 1 && !visited[findIdx]) {
				dfs(findIdx);
			}
		}
	}

	static void bfs(int startIdx) {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[startIdx] = true;
		queue.offer(startIdx);

		while (!queue.isEmpty()) {
			int nowIdx = queue.poll();
			stb.append(nowIdx).append(' ');
			for (int findIdx = 1; findIdx <= n; findIdx++) {
				if (connection[findIdx][nowIdx] == 1 && !visited[findIdx]) {
					visited[findIdx] = true;
					queue.offer(findIdx);
				}
			}
		}
	}
}
