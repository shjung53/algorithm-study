package 숨바꼭질;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, k;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		visited[n] = true;
		int second = 0;

		Queue<Integer> queue = new ArrayDeque<>();

		queue.offer(n);

		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			boolean end = false;
			for (int i = 0; i < queueSize; i++) {
				int now = queue.poll();
				if (now == k) {
					end = true;
					break;
				}
				if (checkBounds(now + 1)) {
					visited[now + 1] = true;
					queue.offer(now + 1);
				}

				if (checkBounds(now - 1)) {
					visited[now - 1] = true;
					queue.offer(now - 1);
				}

				if (checkBounds(now * 2)) {
					visited[now * 2] = true;
					queue.offer(now * 2);
				}
			}
			if (end)
				break;
			second++;
		}

		System.out.println(second);
	}

	private static boolean checkBounds(int x) {
		if (x < 0)
			return false;
		if (x > 100000)
			return false;
		if (visited[x])
			return false;
		return true;
	}

}
