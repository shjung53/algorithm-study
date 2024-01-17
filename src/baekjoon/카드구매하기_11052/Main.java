package baekjoon.카드구매하기_11052;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] price, dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        price = new int[n + 1];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i <= n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1];
        dp[1] = price[1];
        if(n >= 2) dp[2] = Math.max(price[2], price[1] + price[1]);
        if(n >= 3) dp[3] = Math.max(dp[2] + price[1], price[3]);

        for (int i = 4; i <= n; i++) {
            for (int idx = 0; idx < i / 2 - 1; idx++) {
                for(int j = 0; j <= idx; j++) {
                    if ((i & 1) == 1) {
                        dp[i] = Math.max(Math.max(Math.max(dp[i - 1] + price[1], price[i]), dp[i / 2 + idx + 1] + price[i / 2 - idx]), dp[i]);
                    } else {
                        dp[i] = Math.max(Math.max(Math.max(dp[i - 1] + price[1], price[i]), dp[i / 2 + idx] + price[i / 2 - idx]), dp[i]);
                    }
                }
            }
        }

        System.out.println(dp[n]);

    }
}
