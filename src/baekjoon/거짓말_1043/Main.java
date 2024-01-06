package 거짓말_1043;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;

	static boolean[] truth;
	static int[] parent;
	static int[] rank;
	static int[][] party = new int[51][51];
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		truth = new boolean[n + 1];
		rank = new int[n + 1];
		answer = 0;

		st = new StringTokenizer(br.readLine().trim());
		int count = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < count; i++) {
			int person = Integer.parseInt(st.nextToken());
			truth[person] = true;
		}

		// 각 파티별로 루트인 사람을 0번 인덱스에 넣어둔다
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int partyN = Integer.parseInt(st.nextToken()); // 파티에 온 사람 수

			int pre = 0;
			for (int j = 0; j < partyN; j++) {
				int partyPerson = Integer.parseInt(st.nextToken());
				if (pre == 0) {
					pre = partyPerson;
					continue;
				}
				union(pre, partyPerson);
				pre = partyPerson;
			}
			party[i][0] = pre;
		}

		for (int i = 1; i <= m; i++) {
			// 파티의 루트를 재설정
			party[i][0] = findParent(party[i][0]);
			if (!truth[party[i][0]])
				answer++;
		}
		System.out.println(answer);
	}

	private static void union(int x, int y) {
		int xRoot = findParent(x);
		int yRoot = findParent(y);
		if (xRoot == yRoot)
			return;

		if (rank[yRoot] > rank[xRoot]) {
			int temp = xRoot;
			xRoot = yRoot;
			yRoot = temp;
		}

		// 둘중 하나라도 진실을 알면 진실로 만들어야 한다.
		if (truth[xRoot] || truth[yRoot]) {
			truth[xRoot] = true;
			truth[yRoot] = true;
		}

		parent[yRoot] = xRoot;
		rank[xRoot]++;
	}

	private static int findParent(int person) {
		if (parent[person] == person)
			return person;
		return parent[person] = findParent(parent[person]);
	}
}
