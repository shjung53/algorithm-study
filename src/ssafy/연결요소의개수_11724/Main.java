package 연결요소의개수_11724;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int[] rank;
	static int[] parent;
	static int answer;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		rank = new int[n + 1];
		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}

		for (int i = 1; i <= n; i++) {
			if (parent[i] == i)
				answer++;
		}

		System.out.println(answer);

	}

	private static int findParent(int num) {
		if (parent[num] == num)
			return num;
		return parent[num] = findParent(parent[num]);
	}

	private static void union(int x, int y) {
		int xRoot = findParent(x);
		int yRoot = findParent(y);

		if (rank[yRoot] < rank[xRoot]) {
			int temp = xRoot;
			yRoot = xRoot;
			xRoot = temp;
		}

		parent[yRoot] = xRoot;
	}

}
