package 네트워크연결_1922;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int[] parent;
	static int[] rank;
	static int answer;
	static int linkCount;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		m = Integer.parseInt(br.readLine().trim());
		parent = new int[n + 1];
		rank = new int[n + 1];
		answer = 0;
		linkCount = 0;

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		PriorityQueue<Link> queue = new PriorityQueue<Link>(1, new Comparator<Link>() {
			@Override
			public int compare(Link o1, Link o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			queue.offer(new Link(from, to, cost));
		}

		while (!queue.isEmpty()) {
			Link link = queue.poll();
			int x = link.from;
			int y = link.to;

			if (union(x, y)) {
				answer += link.cost;
				linkCount++;
			}

			if (linkCount >= n - 1)
				break;
		}
		
		System.out.println(answer);

	}

	private static int findParent(int computer) {
		if (parent[computer] == computer)
			return computer;
		return parent[computer] = findParent(parent[computer]);
	}

	private static boolean union(int x, int y) {
		int xRoot = findParent(x);
		int yRoot = findParent(y);

		if (xRoot == yRoot)
			return false;

		if (rank[yRoot] > rank[xRoot]) {
			int temp = xRoot;
			xRoot = yRoot;
			yRoot = temp;
		}

		parent[yRoot] = xRoot;
		rank[xRoot]++;
		return true;

	}
}

class Link {
	int from;
	int to;
	int cost;

	public Link(int from, int to, int cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

}
