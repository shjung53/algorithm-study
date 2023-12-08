import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[n];
		dp = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		int idx = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			if (!checkDp(arr[i])) {
				dp[idx] = arr[i];
				idx++;
			}
		}

		// dp의 위치는 현재 마지막 dp값 + 1 -> 즉, 길이
		System.out.println(idx);
	}

	private static boolean checkDp(int num) {
		for (int i = 0; i < n - 1; i++) {
			if (num < dp[i]) {
				dp[i] = num;
				return true;
			}
			if (dp[i] < num && num < dp[i + 1]) {
				dp[i + 1] = num;
				return true;
			}

			if (dp[i] == num)
				return true;
		}
		return false;
	}
}
