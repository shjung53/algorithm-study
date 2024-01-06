package baekjoon.rgb거리_1149;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());

        dp = new int[n][3];
        cost = new int[n][3];

        dp[n - 1][0] = 10000000;
        dp[n - 1][1] = 10000000;
        dp[n - 1][2] = 10000000;

        dp[0][0] = 10000000;
        dp[0][1] = 10000000;
        dp[0][2] = 10000000;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int redCost = Integer.parseInt(st.nextToken());
            int blueCost = Integer.parseInt(st.nextToken());
            int greenCost = Integer.parseInt(st.nextToken());

            cost[i][0] = redCost;
            cost[i][1] = blueCost;
            cost[i][2] = greenCost;
        }

        for (int j = 0; j <= 2; j++) {
            for (int i = 0; i < n; i++) {

                // j로 첫번째 비용을 컨트롤한다.
                if (i == 0) {
                    for (int k = 0; k <= 2; k++) {
                        if (k == j) {
                            dp[i][k] = cost[i][k];
                        } else {
                            dp[i][k] = 10000000;
                        }
                    }
                    continue;
                }

                if(i == n-1) {
                    dp[i][0] = Math.min(dp[i][0],Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0]);
                    dp[i][1] = Math.min(dp[i][1],Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1]);
                    dp[i][2] = Math.min(dp[i][2],Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2]);
                    continue;
                }

                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }
        }

        System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
    }
}
