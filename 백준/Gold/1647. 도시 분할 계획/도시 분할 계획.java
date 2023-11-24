import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int[] parent;
	static int[] rank;
	static int linkCount = 0;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		rank = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		PriorityQueue<Road> queue = new PriorityQueue<Road>(1, new Comparator<Road>() {

			@Override
			public int compare(Road o1, Road o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			queue.offer(new Road(from, to, cost));
		}

		while (!queue.isEmpty()) {
			Road road = queue.poll();
			int from = road.from;
			int to = road.to;
			
			if (linkCount >= n - 2)
				break;

			if (union(from, to)) {
				linkCount++;
				answer += road.cost;
			}

		}

		System.out.println(answer);

	}

	static private int findParent(int village) {
		if (parent[village] == village)
			return village;
		return parent[village] = findParent(parent[village]);
	}

	static private boolean union(int x, int y) {
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

class Road {
	int from;
	int to;
	int cost;

	public Road(int from, int to, int cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

}
