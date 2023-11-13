import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int v;
	static int e;
	static int[] parent;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		parent = new int[v + 1];
		rank = new int[v + 1];
		int answer = 0;
		int edgeCount = 0;

		// 자기 자신이 부모
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(1, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.weight - o2.weight;
			}
		});

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			queue.offer(new Edge(from, to, weight));
		}

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			if (findParent(edge.to) == findParent(edge.from))
				continue;

			int x = edge.to;
			int y = edge.from;

			// x를 큰 값으로 할당
			if (rank[x] < rank[y]) {
				x = edge.from;
				y = edge.to;
			}

			if (union(x, y)) {
				answer += edge.weight;
				edgeCount++;
			} else
				continue;

			if (edgeCount == v - 1)
				break;

		}

		System.out.println(answer);

	}

	private static boolean union(int x, int y) {
		int xRoot = findParent(x);
		int yRoot = findParent(y);

		if (xRoot == yRoot)
			return false;

		parent[yRoot] = xRoot;
		rank[xRoot]++;
		return true;
	}

	private static int findParent(int node) {
		// 자기가 부모면 자기를 반환
		if (parent[node] == node)
			return node;
		// 자기의 부모를 반환하면서 할당, 경로압축
		return parent[node] = findParent(parent[node]);

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
