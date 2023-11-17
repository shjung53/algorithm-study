import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int[] parent;
	static int[] rank;
	static String[] school;
	static int totalDistance;
	static int roadCount;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		rank = new int[n + 1];
		school = new String[n + 1];
		totalDistance = 0;
		roadCount = 0;

		// 거리가 짧은 순서
		PriorityQueue<Road> queue = new PriorityQueue<Road>(1, new Comparator<Road>() {
			@Override
			public int compare(Road o1, Road o2) {
				// TODO Auto-generated method stub
				return o1.distance - o2.distance;
			}
		});

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			school[i] = st.nextToken();
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			// 같은 남초 or 여초 학교면 도로 패스
			if (school[from].equals(school[to]))
				continue;
			queue.offer(new Road(from, to, distance));
		}

		while (!queue.isEmpty()) {
			Road road = queue.poll();
			int x = road.from;
			int y = road.to;

			if (union(x, y)) {
				totalDistance += road.distance;
				roadCount++;
			}

			if (roadCount >= n - 1)
				break;
		}

		if (!check())
			totalDistance = -1;

		System.out.println(totalDistance);
	}

	private static boolean check() {
		int checkCount = 0;
		for (int i = 1; i <= n; i++) {
			if (parent[i] == i)
				checkCount++;
		}

		if (checkCount > 1)
			return false;
		return true;
	}

	private static int findParent(int school) {
		if (parent[school] == school)
			return school;
		return parent[school] = findParent(parent[school]);
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

class Road {
	int from;
	int to;
	int distance;

	public Road(int from, int to, int distance) {
		this.from = from;
		this.to = to;
		this.distance = distance;
	}
}
