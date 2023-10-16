package 트리의부모찾기_11725;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n;

	static ArrayList<Integer>[] link; // 연결된 정점 리스트
	static int[] parent; // 부모 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();

		n = Integer.parseInt(br.readLine().trim());
		link = new ArrayList[n + 1]; //
		parent = new int[n + 1];

		// 초기화
		for (int i = 1; i <= n; i++) {
			link[i] = new ArrayList<>();
		}

		// 연결 추가
		for (int i = 1; i <= n - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			link[v1].add(v2);
			link[v2].add(v1);
		}

		bfs();

		for (int i = 2; i <= n; i++) {
			stb.append(parent[i]).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static void bfs() {

		Queue<Integer> queue = new ArrayDeque<>();

		// 루트  1
		parent[1] = 1;
		queue.offer(1);

		while (!queue.isEmpty()) {
			int node = queue.poll();

			// 연결된 노드들 확인, 부모가 아직 안정해졌으면 부모 정하기
			for (int i = 0; i < link[node].size(); i++) {
				int child = link[node].get(i);
				if (parent[child] != 0)
					continue;
				parent[child] = node;
				queue.offer(child);
			}
		}
	}
}
