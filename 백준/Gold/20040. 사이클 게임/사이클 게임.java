import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] rank;
	static int[] parent;
	static int n;
	static int m;
	static int answer;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		rank = new int[n];
		parent = new int[n];
		answer = 0;

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int dot1 = Integer.parseInt(st.nextToken());
			int dot2 = Integer.parseInt(st.nextToken());

			// 이미 연결된 상태에서 한번 더 연결하려할 때 사이클이 발생한다.
			if (!union(dot1, dot2)) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);
	}

	private static int findParent(int dot) {
		if (parent[dot] == dot)
			return dot;

		return parent[dot] = findParent(parent[dot]);
	}

	private static boolean union(int dot1, int dot2) {
		int dot1P = findParent(dot1);
		int dot2P = findParent(dot2);

		if (dot1P == dot2P)
			return false;

		// dot1P이 더 큰 랭크를 유지
		if (rank[dot2P] > rank[dot1P]) {
			int temp = dot1P;
			dot1P = dot2P;
			dot2P = temp;
		}

		parent[dot2P] = dot1P;
		rank[dot1P]++;
		return true;
	}
}
