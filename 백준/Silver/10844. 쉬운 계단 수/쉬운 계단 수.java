import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        dp = new int[n + 1][10];
        long answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int num = 0; num < 10; num++) {
                if (i == 1) {
                    if(num == 0) continue;
                    dp[i][num] = 1;
                    continue;
                }

                switch (num) {
                    case 0: dp[i][num] = dp[i - 1][num + 1] % 1000000000;
                        break;
                    case 9: dp[i][num] = dp[i - 1][num - 1] % 1000000000;
                        break;
                    default: dp[i][num] = (dp[i - 1][num - 1] + dp[i - 1][num + 1]) % 1000000000;
                        break;
                }
            }
        }

        for(int i=0; i<10; i++) {
            answer += dp[n][i] % 1000000000;
        }

        System.out.println(answer % 1000000000);
    }
}
