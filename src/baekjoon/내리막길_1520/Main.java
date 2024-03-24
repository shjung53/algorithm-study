package baekjoon.내리막길_1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    static int n, m;

    static int[][] map;

    static int[][] dp;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        visited[0][0] = true;
        int answer = findRoute(0, 0);

        System.out.println(answer);
    }

    private static int findRoute(int y, int x) {

        if (y == m - 1 && x == n - 1) {
            return 1;
        }

        if(dp[y][x] > -1) return dp[y][x];

        dp[y][x] = 0;

        for (int k = 0; k < 4; k++) {
            int newY = y + dy[k];
            int newX = x + dx[k];
            if (newY < 0 || newX < 0 || newY >= m || newX >= n) continue;
            if(map[newY][newX] >= map[y][x]) continue;
            if (visited[newY][newX]) continue;
            visited[newY][newX] = true;
            dp[y][x] += findRoute(newY, newX);
            visited[newY][newX] = false;
        }

        return dp[y][x];
    }
}
