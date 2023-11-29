package 펠린드롬_10942;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int[] arr;
	static boolean[][] dp; // dp[i][j]는 i부터 j까지가 팰린드롬인지에 대한 true, false

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		arr = new int[n + 1];
		dp = new boolean[n + 1][n + 1];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// k는 길이, 길이로 컨트롤한다. 길이가 짧은 것부터 검사해야 큰것을 검사할 수 있다.
		for (int k = 1; k <= n; k++) {
			// 시작 위치 i로 컨트롤
			for (int i = 1; i + k - 1 <= n; i++) {
				if (k == 1) {
					dp[i][i + k - 1] = true;
					continue;
				}

				if (k == 2) {
					if (arr[i] == arr[i + k - 1]) {
						dp[i][i + k - 1] = true;
					}
					continue;
				}

				if (dp[i + 1][i + k - 2]) {
					if (arr[i] == arr[i + k - 1])
						dp[i][i + k - 1] = true;
				}
			}
		}

		m = Integer.parseInt(br.readLine().trim());
		StringBuilder stb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (dp[s][e]) {
				stb.append(1).append('\n');
			} else {
				stb.append(0).append('\n');
			}
		}

		System.out.println(stb);
	}
}
