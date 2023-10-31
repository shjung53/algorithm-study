package n과m4;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int[] combi;
	static StringBuilder stb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		combi = new int[m];
		dfs(1, 0);
		System.out.println(stb);

	}

	private static void dfs(int num, int length) {

		if (length == m) {
			for (int i : combi) {
				stb.append(i).append(' ');
			}
			stb.append('\n');
			return;
		}

		for (int i = num; i <= n; i++) {
			combi[length] = i;
			dfs(i, length + 1);
		}
	}
}
