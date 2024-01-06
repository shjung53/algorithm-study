package 효율적인해킹_1325;

import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<ArrayList<Integer>> board;
	static int[] count;
	static boolean[] visited;
	static int n;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder stb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		board = new ArrayList<ArrayList<Integer>>();
		count = new int[n + 1];

		for (int i = 1; i <= n+1; i++) {
			board.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
//			해킹할 수 있는 컴퓨터 추가
			board.get(b).add(a);
		}

		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			bfs(i);
			if (count[i] > max)
				max = count[i];
		}

		for (int i = 1; i <= n; i++) {
			if (count[i] == max)
				stb.append(i).append(' ');
		}

		System.out.println(stb);

	}

	private static void bfs(int num) {
		Queue<Integer> queue = new ArrayDeque<>();
//		현 bfs 방문 visited
		visited[num] = true;
		queue.offer(num);
		count[num]++;
		while (!queue.isEmpty()) {
			int child = queue.poll();
//			현재 i에서 해킹할 수 있는 컴퓨터들 
			for (int next : board.get(child)) {
				if (visited[next])
					continue;
				visited[next] = true;
//				현 bfs 최상위 컴퓨터 카운트 추가
				count[num]++;
				queue.offer(next);
			}
		}
	}
}
