package 트리의지름;

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		nodes = new Node[n + 1];
		answer = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			nodes[parent].children.add(new Edge(child, length));
		}

		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> lines = new ArrayList<Integer>();
			for (int j = 0; j < nodes[i].children.size(); j++) {
				// 라인 길이 초기화
				line = 0;
				maxLine = 0;
				Edge edge = nodes[i].children.get(j);
				// 간선길이 더하고 간선으로 이동해서 리프노드까지의 거리를 모두 더한다.
				line += edge.length;
				addLength(edge.to);
				lines.add(maxLine);
			}

			Collections.sort(lines, Collections.reverseOrder());

			sum = 0;

			for (int j = 0; j < lines.size(); j++) {
				if (j >= 2)
					break;
				sum += lines.get(j);
			}

			if (answer < sum)
				answer = sum;

		}

		System.out.println(answer);
	}

	// 큰 간선만 골라서 계속 내려가면서 가장 긴 간선의 길이를 더한다
	private static void addLength(int nodeIdx) {
		if (line > maxLine)
			maxLine = line;
		for (int i = 0; i < nodes[nodeIdx].children.size(); i++) {
			Edge edge = nodes[nodeIdx].children.get(i);
			line += edge.length;
			addLength(edge.to);
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
