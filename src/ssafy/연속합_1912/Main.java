package ssafy.연속합_1912;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, answer;

    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = arr[i];
                answer = dp[i];
                continue;
            }
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            if(dp[i] > answer) answer = dp[i];
        }

        System.out.println(answer);

    }
}
