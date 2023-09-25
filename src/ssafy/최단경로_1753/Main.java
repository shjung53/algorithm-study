package 최단경로_1753;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int v; // 정점의 개수
	static int e; // 간선의 개수
	static int[][] connection; // 간선 연결 정보, 0보다 크면 간선존재, 값은 가중치 값
	static int start; // 시작 정점
	static int[] visited; // 정점 방문 시점의 가중치의 합

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine().trim());
		StringBuilder stb = new StringBuilder();

		connection = new int[v + 1][v + 1];

		for (int inputIdx = 0; inputIdx < e; inputIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			if (connection[from][to] == 0) {
				connection[from][to] = weight;
			} else {
				if (weight < connection[from][to])
					connection[from][to] = weight;
			}
		}

		for (int goal = 1; goal <= v; goal++) {
			visited = new int[v + 1];
			if (bfs(goal)) {
				stb.append(visited[goal]);
			} else {
				stb.append("INF");
			}
			if (goal != v)
				stb.append('\n');
		}
		System.out.println(stb.toString());
	}

	private static boolean bfs(int goal) {
		boolean possible = false;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			if (now == goal) {
				possible = true;
				break;
			}
			for (int vIdx = 1; vIdx <= v; vIdx++) {
				if (connection[now][vIdx] > 0
						&& (visited[vIdx] == 0 || visited[vIdx] > visited[now] + connection[now][vIdx])) {
					visited[vIdx] = visited[now] + connection[now][vIdx];
					queue.offer(vIdx);
				}
			}
		}

		return possible;
	}
}
