import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int[][] dp;
	static int[] memory;
	static int[] cost;
	static int answer;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		memory = new int[n + 1];
		cost = new int[n + 1];

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 1; i <= n; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[n + 1][100 * n + 1];

		// j는 총 비용, i는 앱의 번호(1번부터 시작)
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= 100 * n; j++) {
				if(j - cost[i] < 0) {
					dp[i][j] = dp[i-1][j];
					continue;
				} // 이 앱의 비용을 확보할 수 없는 경우
				
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - cost[i]] + memory[i]);
				if(dp[i][j] >= m) {
					if(answer > j) answer = j;
				}
			}
		}

		System.out.println(answer);

	}
}
