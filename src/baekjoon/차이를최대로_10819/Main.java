package baekjoon.차이를최대로_10819;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n, answer;
    static int[] arr;

    static boolean[] visited;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        arr = new int[n];
        visited = new boolean[n];
        selected = new int[n];
        answer = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine().trim());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(answer);

    }

    private static void dfs(int idx) {
        if(idx >= n) {
            int sum = 0;
            for(int i=1; i<n; i++) {
                sum += Math.abs(arr[selected[i]] - arr[selected[i - 1]]);
            }
            if(sum > answer) answer = sum;
            return;
        }

        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected[idx] = i;
            dfs(idx + 1);
            visited[i] = false;
        }
    }
}
