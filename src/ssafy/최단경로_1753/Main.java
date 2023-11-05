package 최단경로_1753;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int v; // 정점의 개수
	static int e; // 간선의 개수
	static int start; // 시작 정점
	static Edge[] edges;
	static Node[] nodes;
	static int[] visited; // 정점 방문 시점의 가중치

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine().trim());
		StringBuilder stb = new StringBuilder();

		nodes = new Node[v + 1];
		edges = new Edge[e];

		for (int i = 0; i < v + 1; i++) {
			nodes[i] = new Node();
		}

		for (int eIdx = 0; eIdx < e; eIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[eIdx] = new Edge(from, to, weight);
			nodes[from].edges.add(eIdx);
		}

		bfs(start);

		for (int i = 1; i <= v; i++) {
			if (i == start) {
				stb.append(0).append('\n');
				continue;
			}

			if (nodes[i].weight == 0) {
				stb.append("INF").append('\n');
				continue;
			}

			stb.append(nodes[i].weight).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(start); // 시작노드를 넣는다.

		while (!queue.isEmpty()) {
			int nowIdx = queue.poll();
			Node now = nodes[nowIdx];

			for (int eIdx = 0; eIdx < now.edges.size(); eIdx++) {
				Edge edge = edges[now.edges.get(eIdx)];
				if (nodes[edge.to].weight != 0) {
					if (now.weight + edge.weight > nodes[edge.to].weight)
						continue;
				}
				nodes[edge.to].weight = now.weight + edge.weight;
				queue.offer(edge.to);
			}
		}
	}
}

class Edge {
	int from;
	int to;
	int weight;

	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

class Node {
	int weight = 0;
	ArrayList<Integer> edges = new ArrayList<Integer>();
}
