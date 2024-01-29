package baekjoon.동물원_1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static int n;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        dp = new int[n][3];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
        }

        System.out.println((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % 9901);
    }
}
