package 가장긴증가하는부분수열2_12015;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n;
	static int[] dp; // dp[i]는 길이가 i인 부분 수열의 가장 마지막 수의 최소값
	static int length;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[n + 1];
		dp = new int[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		length = 1;

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			setDp(arr[i]);
		}

		System.out.println(length - 1);
	}

	private static void setDp(int num) {
		int min = 0;
		int max = length - 1;

		if (num > dp[length - 1]) {
			dp[length] = num;
			length++;
			return;
		}

		while (min < max) {
			int mid = (min + max) / 2;
			if (dp[mid] >= num) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		dp[max] = num;
	}
}
