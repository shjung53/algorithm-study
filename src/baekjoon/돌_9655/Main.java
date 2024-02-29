package baekjoon.돌_9655;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;

    static int n;

    static boolean[] dp; // true는 SK 승, false는 CY 승

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = true;
                continue;
            }
            if (i == 2) {
                dp[i] = false;
                continue;
            }
            if (i == 3) {
                dp[i] = true;
                continue;
            }

            if (dp[i - 1] && dp[i - 3]) {
                dp[i] = false;
            } else {
                dp[i] = true;
            }
        }

        if(dp[n]) {
            System.out.println("SK");
        }else {
            System.out.println("CY");
        }
    }
}
