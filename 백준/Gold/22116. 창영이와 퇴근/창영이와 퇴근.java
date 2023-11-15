import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[][] arr;
	static int[] parent;
	static int[] rank;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim());

		arr = new int[n][n];
		parent = new int[n * n];
		rank = new int[n * n];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 경사 차이가 적은 경로부터 오름차순
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(1, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.slope - o2.slope;
			}
		});
		
		HashSet<Edge> set = new HashSet<Edge>();

		// 상하좌우 경로 확인하고 큐에 삽입
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 부모 초기화 -> 자기 자신
				parent[i * n + j] = i * n + j;
				for (int k = 0; k < 4; k++) {
					int newY = i + dy[k];
					int newX = j + dx[k];
					// 범위 오바면 패스
					if (newY < 0 || newX < 0 || newY >= n || newX >= n)
						continue;
					// 연결 지점
					int from = i * n + j;
					int to = newY * n + newX;
					if (from > to) {
						int temp = from;
						from = to;
						to = temp;
					}
					int slope = Math.abs(arr[i][j] - arr[newY][newX]);
					set.add(new Edge(from, to, slope));
				}
			}
		}
		
		queue.addAll(set);

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();

			int x = edge.from;
			int y = edge.to;

			if (rank[y] > rank[x]) {
				x = edge.to;
				y = edge.from;
			}
			if (union(x, y)) {
				// 연결한 경사가 기존 최대 경사보다 크면 업데이트
				if (edge.slope > answer)
					answer = edge.slope;
			}

			// 출발점과 목적지가 연결되었는지 확인
			if (findParent(parent[0]) == findParent(parent[n * n - 1]))
				break;
		}
		System.out.println(answer);
	}

	// 부모찾기
	private static int findParent(int node) {
		if (parent[node] == node)
			return node;
		return parent[node] = findParent(parent[node]);
	}

	// 경로 연결, 무조건 랭크가 높거나 같도록 앞에서 설정
	private static boolean union(int x, int y) {
		int rootX = findParent(x);
		int rootY = findParent(y);

		// 이미 연결되어 있으면 합칠 수 없음
		if (rootX == rootY)
			return false;
		parent[rootY] = parent[rootX];
		rank[rootX]++;
		return true;
	}
}

class Edge {
	int from;
	int to;
	int slope;

	public Edge(int from, int to, int slope) {
		super();
		this.from = from;
		this.to = to;
		this.slope = slope;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + from;
		result = prime * result + slope;
		result = prime * result + to;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (from != other.from)
			return false;
		if (slope != other.slope)
			return false;
		if (to != other.to)
			return false;
		return true;
	}

}
