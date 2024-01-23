package baekjoon.토마토_7576;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n, m;
    static int[][] box;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];
        int time = -1;

        Queue<Position> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) queue.offer(new Position(i, j));
            }
        }

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                Position now = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newY = now.y + dy[k];
                    int newX = now.x + dx[k];
                    if (newY < 0 || newX < 0 || newY >= n || newX >= m || box[newY][newX] != 0) continue;
                    box[newY][newX] = 1;
                    queue.offer(new Position(newY, newX));
                }
            }
            time++;
        }


        Loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    time = -1;
                    break Loop;
                }
            }
        }
        System.out.println(time);
    }

}


class Position {
    int y, x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
