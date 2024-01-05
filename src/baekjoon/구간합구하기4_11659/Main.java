package 구간합구하기4_11659;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] sum; // 1부터 index까지의 합
	static int n;
	static int m;
	static int s;
	static int e;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		sum = new int[n + 1];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			stb.append(sum[e] - sum[s - 1]).append('\n');
		}

		System.out.println(stb);
	}

}
