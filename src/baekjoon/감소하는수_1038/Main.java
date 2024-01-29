package baekjoon.감소하는수_1038;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int n, count;

    static int answer;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        arr = new int[10];
        count = -1;
        answer = 0;

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int idx) {
        if(count == n) {
            for(int i=0; i<idx; i++) {
                answer += answer * 10 + arr[i];
            }
            return;
        }
        if (idx >= 10) return;

        for (int i = 0; i < 10; i++) {
            if (idx - 1 >= 0) {
                if (arr[idx - 1] <= i) continue;
            }
        }
    }
}
