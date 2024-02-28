package programmers.레벨3;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private static final int MOD = 10007;
    public static void main(String[] str) {
        int n = 100000;
        int[] tops = new int[100000]; // 배열 크기 10만 설정
        Random random = new Random(); // Random 객체 생성

        // 배열의 각 위치에 0 또는 1 랜덤하게 할당
        for (int i = 0; i < tops.length; i++) {
            tops[i] = random.nextInt(2); // 0 또는 1 랜덤 값 생성
        }

        System.out.println(Arrays.toString(tops));
        int[][] DP = new int[n + 1][2];
        DP[0][1] = 1;
        for (int i = 0; i < n; i++) {
            int top = tops[i];
            int k = i + 1;
            DP[k][0] = (DP[i][0] + DP[i][1]) % MOD;
            if (top == 0) {
                DP[k][1] = (DP[i][0] + DP[i][1] * 2) % MOD;
            } else {
                DP[k][1] = (DP[i][0] * 2 + DP[i][1] * 3) % MOD;
            }
        }

        System.out.println((DP[n][0] + DP[n][1]) % MOD);
    }
}
