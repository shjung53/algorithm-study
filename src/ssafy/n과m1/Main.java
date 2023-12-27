package ssafy.n과m1;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int m;
    static int[] permutation;
    static boolean[] visited;
    static StringBuilder stb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        permutation = new int[m];
        visited = new boolean[n + 1];
        dfs(1, 0);
        System.out.println(stb);

    }

    private static void dfs(int num, int length) {

        if (length == m) {
            for (int i : permutation) {
                stb.append(i).append(' ');
            }
            stb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            permutation[length] = i;
            dfs(i + 1, length + 1);
            visited[i] = false;
        }
    }
}
