import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        dp = new int[n + 1];
        getDp(n);

        System.out.println(dp[n]);
    }

    private static int getDp(int num) {
        if(num == 1) return dp[num] = 1;
        if(num == 2) return dp[num] = 2;
        if(num == 3) return dp[num] = 3;
        if(dp[num] != 0) return dp[num];
        
        return dp[num] = (getDp(num - 1) + getDp(num - 2)) % 10007;
    }
}
