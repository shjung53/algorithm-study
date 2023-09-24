package 수익_4097;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static int n;
	static int[] arr;
	static int[] dp;
	static int maxProfit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim());

		// 테스트 케이스가 0이면 끝
		while (n != 0) {
			arr = new int[n];
			dp = new int[n];
			maxProfit = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine().trim());
			}

			for (int i = 0; i < n; i++) {
				if (i == 0) {
					dp[i] = arr[i];
					if (maxProfit < dp[i])
						maxProfit = dp[i];
					continue;
				}
				dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
				if (maxProfit < dp[i])
					maxProfit = dp[i];
			}
			System.out.println(maxProfit);
			// 다음 테스트 케이스 n받기
			n = Integer.parseInt(br.readLine().trim());
		}

	}
}
