package ssafy.포도주시식_2156;

import java.io.*;

public class Main {
    static BufferedReader br;
    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        arr = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        for (int i = 0; i < n; i++) {
            dp[i] = getDp(i);
        }

        System.out.println(dp[n - 1]);
    }

    public static int getDp(int idx) {
        if (idx == 0) return dp[idx] = arr[0];
        if (idx == 1) return dp[idx] = arr[0] + arr[1];
        if (idx == 2) return Math.max(Math.max(arr[0] + arr[1], arr[0] + arr[2]), arr[1] + arr[2]);
        if (dp[idx] == 0)
            return dp[idx] = Math.max(Math.max(dp[idx - 1], dp[idx - 2] + arr[idx]), dp[idx - 3] + arr[idx - 1] + arr[idx]);
        return dp[idx];
    }
}
