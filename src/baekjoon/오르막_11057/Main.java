package baekjoon.오르막_11057;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] dp;

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        dp = new int[n + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }

        System.out.println(answer % 10007);
    }
}
