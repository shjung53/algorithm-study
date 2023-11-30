package 효율적인해킹_1325;

import java.util.*;
import java.io.*;

public class Main {
	static HashSet<Integer>[] infect;
	static HashSet<Integer>[] infectedBy;
	static int[] count;
	static int n;
	static int m;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder stb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		infect = new HashSet[n + 1];
		infectedBy = new HashSet[n + 1];
		count = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			infect[i] = new HashSet<Integer>();
			infectedBy[i] = new HashSet<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
//			해킹할 수 있는 컴퓨터 추가
			infect[b].add(a);
			infectedBy[a].add(b);
		}

		for (int i = 1; i <= n; i++) {
			if (count[i] > 0)
				continue;
			bfs(i);
			if (count[i] > max) {
				max = count[i];
				stb.setLength(0);
				stb.append(i).append(' ');
				continue;
			}

			if (count[i] == max) {
				stb.append(i).append(' ');
			}
		}

		System.out.println(stb);

	}

	private static int bfs(int num) {
		visited = new boolean[n + 1];
		visited[num] = true;
		int subCount = 1;

//			현재 num에서 해킹할 수 있는 컴퓨터들 
		for (int next : infect[num]) {
			if (visited[next])
				continue;
			visited[next] = true;
			count[num] += bfs(next);
		}

		return count[num];
	}
}
