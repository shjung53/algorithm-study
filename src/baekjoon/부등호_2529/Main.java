package baekjoon.부등호_2529;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int k;

    static long max, min;

    static String[] signs;

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine().trim());
        signs = new String[k];
        st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<k; i++) {
            signs[i] = st.nextToken();
        }
        visited = new boolean[10];
        arr = new int[k + 1];
        max = 0;
        min = 10000000000L;

        dfs(0);
        String maxAnswer = Long.toString(max);
        String minAnswer = Long.toString(min);
        if(maxAnswer.length() < k + 1) maxAnswer = "0" + maxAnswer;
        if(minAnswer.length() < k + 1) minAnswer = "0" + minAnswer;
        System.out.println(maxAnswer);
        System.out.println(minAnswer);

    }

    private static void dfs(int idx) {
        if (idx > k) {
            long result = makeInt();
            if (min > result) min = result;
            if (max < result) max = result;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (idx != 0) {
                if (visited[i]) continue;
                if (signs[idx - 1].equals("<")) {
                    if (arr[idx - 1] > i) continue;
                } else {
                    if (arr[idx - 1] < i) continue;
                }

            }
            visited[i] = true;
            arr[idx] = i;
            dfs(idx + 1);
            visited[i] = false;
        }

    }

    private static long makeInt() {
        long result = 0;
        for (int i = 0; i <= k; i++) {
            result = result * 10 + arr[i];
        }
        return result;
    }
}
