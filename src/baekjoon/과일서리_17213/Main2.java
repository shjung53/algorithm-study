package baekjoon.과일서리_17213;

import java.util.*;
import java.io.*;
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dp = new int[11][31];
        for (int i = 1; i <= m; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= m; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
            }
        }
        System.out.print(dp[n][m]);
    }
}
