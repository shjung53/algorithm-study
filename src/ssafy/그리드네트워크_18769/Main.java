package 그리드네트워크_18769;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int r;
	static int c;
	static int[] parent;
	static int[] rank;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int test = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= test; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			parent = new int[r * c];
			rank = new int[r * c];

			PriorityQueue<Link> queue = new PriorityQueue<Link>(1, new Comparator<Link>() {

				@Override
				public int compare(Link o1, Link o2) {
					// TODO Auto-generated method stub
					return o1.weight - o2.weight;
				}
			});

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					parent[i * c + j] = i * c + j;
				}
			}

			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < c - 1; j++) {
					int weight = Integer.parseInt(st.nextToken());
					int from = i * c + j;
					int to = i * c + j + 1;
					queue.offer(new Link(from, to, weight));
				}
			}

			for (int i = 0; i < r - 1; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < c; j++) {
					int weight = Integer.parseInt(st.nextToken());
					int from = i * c + j;
					int to = i * c + j + c;
					queue.offer(new Link(from, to, weight));
				}
			}
			int linkCount = 0;
			int answerCost = 0;

			while (!queue.isEmpty()) {
				Link link = queue.poll();
				int x = link.to;
				int y = link.from;

				if (rank[x] < rank[y]) {
					x = link.from;
					y = link.to;
				}

				if (union(x, y)) {
					linkCount++;
					answerCost += link.weight;
				} else {
					continue;
				}

				if (linkCount >= r * c - 1)
					break;
			}

			stb.append(answerCost).append('\n');
		}

		System.out.println(stb);

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

	private static int findParent(int server) {
		if (parent[server] == server)
			return server;

		return parent[server] = findParent(parent[server]);
	}
}

class Link {
	int from;
	int to;
	int weight;

	public Link(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

}
