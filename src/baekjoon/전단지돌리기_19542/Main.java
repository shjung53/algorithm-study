package 전단지돌리기_19542;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int s;
	static int d;
	static Node[] nodes;
	static int answer;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		nodes = new Node[n + 1];
		for (int i = 1; i <= n; i++) {
			nodes[i] = new Node();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			nodes[node1].link.add(node2);
			nodes[node2].link.add(node1);
		}

		visited = new boolean[n + 1];
		visited[s] = true;
		nodes[s].distance = maxFromHere(s);
		answer = 0;
		visited = new boolean[n + 1];
		visited[s] = true;
		countDistance(s);
		System.out.println(answer * 2);
	}

	private static void countDistance(int nodeIdx) {
		if (nodes[nodeIdx].distance <= d)
			return;

		for (int nextNode : nodes[nodeIdx].link) {
			if (visited[nextNode])
				continue;
			if (nodes[nextNode].distance < d)
				continue;
			visited[nextNode] = true;
			answer++;
			countDistance(nextNode);
		}
	}

	private static int maxFromHere(int nodeIdx) {

		boolean isLeaf = true;
		for (int nextNode : nodes[nodeIdx].link) {
			if (visited[nextNode])
				continue;
			isLeaf = false;
			visited[nextNode] = true;
			nodes[nodeIdx].distance = Math.max(nodes[nodeIdx].distance, maxFromHere(nextNode) + 1);
		}

		if (isLeaf)
			return 0;

		return nodes[nodeIdx].distance;
	}
}

class Node {
	int distance = 0; // 리프노드까지의 거리
	ArrayList<Integer> link = new ArrayList<Integer>();
}
