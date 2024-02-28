package baekjoon.이친수_2193;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;

    static int n;

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        dp = new long[n + 1][2];
        dp[1][1] = 1;
        dp[1][0] = 0;

        for(int i=2; i<=n; i++) {
            dp[i][1] = dp[i - 1][0];
            dp[i][0] = dp[i - 1][1] + dp[i - 1][0];
        }

        System.out.println(dp[n][1] + dp[n][0]);
    }
}
