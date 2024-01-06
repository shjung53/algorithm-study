package 트리의지름_1167;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n;
	static Node[] nodes;
	static int line;
	static int maxLine;
	static int sum;
	static int answer;
	static boolean[] visited;
	static int pre;
	static int count;
	static int start;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		nodes = new Node[n + 1];
		answer = Integer.MIN_VALUE;
		count = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int parent = Integer.parseInt(st.nextToken());
			if (count < st.countTokens()) {
				count = st.countTokens();
				pre = parent;
			}
			while (true) {
				int check = Integer.parseInt(st.nextToken());
				if (check == -1)
					break;
				int child = check;
				int length = Integer.parseInt(st.nextToken());
				nodes[parent].children.add(new Edge(child, length));
			}
		}

		// 1번 노드로부터 가장 먼 노드 구하기
		visited = new boolean[n + 1];
		visited[pre] = true;
		// 라인 길이 초기화
		line = 0;
		maxLine = 0;
		visited[pre] = true;
		addLength(pre);

		// 시작노드 구했으니 시작 노드에서 가장 먼 노드 구하면 그 길이가 지름
		line = 0;
		maxLine = 0;
		visited = new boolean[n + 1];
		visited[start] = true;
		addLength(start);

		System.out.println(maxLine);
	}

	// 간선을 dfs로 선택하면서 가장 긴 지름의 길이를 구한다.
	private static void addLength(int nodeIdx) {
		if (line > maxLine) {
			start = nodeIdx;
			maxLine = line;
		}
		for (int i = 0; i < nodes[nodeIdx].children.size(); i++) {
			Edge edge = nodes[nodeIdx].children.get(i);
			if (visited[edge.to])
				continue;
			visited[edge.to] = true;
			line += edge.length;
			addLength(edge.to);
			visited[edge.to] = false;
			line -= edge.length;
		}
	}
}

class Node {
	int here;
	ArrayList<Edge> children;

	public Node(int here) {
		super();
		this.here = here;
		this.children = new ArrayList<Edge>();
	}

}

class Edge {
	int to;
	int length;

	public Edge(int to, int length) {
		super();
		this.to = to;
		this.length = length;
	}

}