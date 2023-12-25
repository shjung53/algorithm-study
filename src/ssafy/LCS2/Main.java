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

        dp = new int[str2.length() + 1][str1.length() + 1];

        for (int i = 1; i <= str2.length(); i++) {
            for (int j = 1; j <= str1.length(); j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder stb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        int y = str2.length();
        int x = str1.length();

        while (x >0 && y >0) {
            if (dp[y][x] == dp[y][x - 1]) {
                x = x - 1;
            } else if (dp[y][x] == dp[y - 1][x]) {
                y = y - 1;
            } else {
                stack.push(str1.charAt(x - 1));
                y = y - 1;
                x = x - 1;
            }
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
