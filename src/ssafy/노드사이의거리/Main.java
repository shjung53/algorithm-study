package 노드사이의거리;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static ArrayList<Edge>[] link;
	static boolean[] visited;
	static int goal;
	static int answer;

	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		StringBuilder stb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		link = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			link[i] = new ArrayList<Edge>();
		}

		for (int i = 1; i <= n - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			link[v1].add(new Edge(v2, dis));
			link[v2].add(new Edge(v1, dis));
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			goal = Integer.parseInt(st.nextToken());

			visited = new boolean[n + 1];
			visited[start] = true;

			dfs(start, 0);

			stb.append(answer).append('\n');
		}
		System.out.println(stb.toString());
	}

	// 백트래킹
	private static void dfs(int v, int totalDis) {
		// 목표 노드에 도착하면 정답에 거리 할당
		if (v == goal) {
			answer = totalDis;
			return;
		}

		// 연결된 간선들 돌기
		for (int i = 0; i < link[v].size(); i++) {
			// 연결된 다음 노드와 거리
			int next = link[v].get(i).to;
			int dis = link[v].get(i).dis;
			// 방문했으면 넘어가기
			if (visited[next])
				continue;
			// 방문 안했으면  방문처리하고 해당 노드로 이동
			visited[next] = true;
			dfs(next, totalDis + dis);
			// 다른 간선 확인하기 위해 방문처리 해제
			visited[next] = false;
		}
	}
}

class Edge {
	int to;
	int dis;

	public Edge(int to, int dis) {
		super();
		this.to = to;
		this.dis = dis;
	}
}
