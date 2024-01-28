package baekjoon.고층건물_1027;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static BufferedReader br;
    static StringTokenizer st;
    static int[] height;
    static int[] countArr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine().trim());
        countArr = new int[n];
        height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int standard = 0; standard < n; standard++) {

            int left = standard - 1;
            int right = standard + 1;

            double leftMaxDecline = Integer.MIN_VALUE;
            double rightMaxDecline = Integer.MIN_VALUE;
            int count = 0;

            while (left >= 0) {
                if (leftMaxDecline < (double) (height[left] - height[standard]) / (standard - left)) {
                    leftMaxDecline = ((double) (height[left] - height[standard]) / (standard - left));
                    count++;
                }
                left--;
            }

            while (right < n) {
                if (rightMaxDecline < (double) (height[right] - height[standard]) / (right - standard)) {
                    rightMaxDecline = (double) (height[right] - height[standard]) / (right - standard);
                    count++;
                }
                right++;
            }

            countArr[standard] = count;
        }

        int answer = 0;
        for (int count : countArr) {
            if (answer < count) answer = count;
        }

        System.out.println(answer);
    }
}
