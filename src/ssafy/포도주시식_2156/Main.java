package ssafy.포도주시식_2156;

import java.util.*;
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

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        for(int i=0; i<n; i++) {
            dp[i] = Math.max(arr[i-1] + dp[i-2], dp[i-2] + arr[i]);
        }
    }
}
