package ssafy.LCS2;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static String str1, str2;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine().trim();
        str2 = br.readLine().trim();

        dp = new int[str2.length()][str1.length()];

        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                if (str2.charAt(i) == str1.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + 1;
                        if(dp[i][j] > i + 1) dp[i][j] = i + 1;
                    }
                } else {
                    int var1 = 0, var2 = 0;
                    if (i - 1 >= 0) var1 = dp[i - 1][j];
                    if (j - 1 >= 0) var2 = dp[i][j - 1];
                    dp[i][j] = Math.max(var1, var2);
                }
            }
        }

        StringBuilder stb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        int y = str2.length() - 1;
        int x = str1.length() - 1;

        while (x >= 0 || y >= 0) {

            if (y < 0 || x < 0) break;

            if (x > 0) {
                if (dp[y][x] == dp[y][x - 1]) {
                    x = x - 1;
                    continue;
                }
            }
            if (y > 0) {
                if (dp[y][x] == dp[y - 1][x]) {
                    y = y - 1;
                    continue;
                }
            }

            stack.push(str1.charAt(x));
            y = y - 1;
            x = x - 1;
        }

        while (!stack.isEmpty()) {
            stb.append(stack.pop());
        }

        System.out.println(stb.length());
        if (stb.length() > 0) {
            System.out.println(stb);
        }

    }
}
