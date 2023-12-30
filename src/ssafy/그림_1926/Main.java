package ssafy.그림_1926;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n, m, paintCount, paintSize;
    static int[][] map;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        paintCount = 0;
        paintSize = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    paintCount++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(paintCount);
        System.out.println(paintSize);
    }

    private static void bfs(int y, int x) {
        Queue<Position> queue = new ArrayDeque<>();

        int count = 0;
        map[y][x] = 0;
        queue.offer(new Position(y, x));

        while (!queue.isEmpty()) {
            Position now = queue.poll();
            count++;

            for (int k = 0; k < 4; k++) {
                int newY = now.y + dy[k];
                int newX = now.x + dx[k];

                if (newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if (map[newY][newX] != 1) continue;
                map[newY][newX] = 0;
                queue.offer(new Position(newY, newX));
            }
        }

        if (count > paintSize) paintSize = count;
    }
}

class Position {
    int y, x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
