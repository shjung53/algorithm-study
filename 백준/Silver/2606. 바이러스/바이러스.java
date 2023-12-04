import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static ArrayList<Integer>[] computers;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int m = Integer.parseInt(br.readLine().trim());

		computers = new ArrayList[n + 1];
		count = 0;

		for (int i = 1; i <= n; i++) {
			computers[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			computers[com1].add(com2);
			computers[com2].add(com1);
		}

		visited = new boolean[n + 1];
		bfs();
		System.out.println(count);
	}

	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();

		visited[1] = true;
		queue.offer(1);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int next : computers[now]) {
				if (visited[next])
					continue;

				count++;
				visited[next] = true;
				queue.offer(next);
			}
		}
	}

}
