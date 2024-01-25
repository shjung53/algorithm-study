package baekjoon.설탕배달_2839;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] dp;

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = 5001;
        }

        if(n >= 3) dp[3] = 1;
        if(n >= 5) dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }

        if(dp[n] > 5000) dp[n] = -1;

        System.out.println(dp[n]);
    }

}
