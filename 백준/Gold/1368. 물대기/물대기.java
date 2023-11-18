import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[][] map;
	static int[] parent;
	static int[] rank;
	static boolean[] isWatered;
	static int totalCost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		isWatered = new boolean[n];
		rank = new int[n];
		parent = new int[n];
		totalCost = 0;

		PriorityQueue<Watering> queue = new PriorityQueue<Watering>(1, new Comparator<Watering>() {
			@Override
			public int compare(Watering o1, Watering o2) {
				return o1.cost - o2.cost;
			}
		});

		for (int i = 0; i < n; i++) {
			parent[i] = i;
			int cost = Integer.parseInt(br.readLine().trim());
			queue.offer(new Watering(i, i, cost));
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 논에서 논으로 물대는 비용, 1번만 넣는다
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				queue.offer(new Watering(i, j, map[i][j]));
			}
		}

		while (!queue.isEmpty()) {
			Watering watering = queue.poll();

			if (allWatered())
				break;

			// 우물을 파는 경우
			if (watering.from == watering.to) {
				int land = watering.from;

				// 우물을 파면 연결된 루트에 물을 댈 수 있다.
				int rootLand = findParent(land);

				// 이미 물이 있는 경우 패스
				if (isWatered[rootLand])
					continue;

				// 아닌 경우 우물을 파서 물을 댄다.
				isWatered[rootLand] = true;
				totalCost += watering.cost;
			} else {
				// 연결만 하는 경우
				int x = watering.from;
				int y = watering.to;

				if (union(x, y)) {
					totalCost += watering.cost;
				}
			}
		}

		System.out.println(totalCost);

	}

	private static boolean allWatered() {
		for (int i = 0; i < n; i++) {
			if (parent[i] == i) {
				if (!isWatered[i])
					return false;
			}
		}

		return true;
	}

	private static boolean union(int x, int y) {
		int xRoot = findParent(x);
		int yRoot = findParent(y);

		// 이미 연결되어있으면 패스
		if (xRoot == yRoot)
			return false;
		
		if (isWatered[yRoot] && isWatered[xRoot])
			return false;

		if (rank[yRoot] > rank[xRoot]) {
			int temp = xRoot;
			xRoot = yRoot;
			yRoot = temp;
		}

		// 두 루트 논 중 하나라도 물을 댄 상태라면 물줄기가 연결된다.
		if (isWatered[yRoot] || isWatered[xRoot])
			isWatered[xRoot] = true;
		parent[yRoot] = xRoot;
		rank[xRoot]++;
		return true;
	}

	private static int findParent(int land) {
		if (parent[land] == land)
			return land;
		return parent[land] = findParent(parent[land]);
	}
}

class Watering {
	int from;
	int to;
	int cost;

	public Watering(int from, int to, int cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

}
