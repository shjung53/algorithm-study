package baekjoon.이동하기_11048;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int[][] maze;

    static int n, m;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                dp[i][j] = Math.max(Math.max(dp[i-1][j] + maze[i][j], dp[i][j - 1] + maze[i][j]), dp[i - 1][j - 1] + maze[i][j]);
            }
        }

        System.out.println(dp[n][m]);
    }
}
