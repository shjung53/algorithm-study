package baekjoon.적록색약_10026;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;

    static int n, person1, person2;

    static char[][] map1, map2;

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        map1 = new char[n][n];
        map2 = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine().trim();
            for (int j = 0; j < n; j++) {
                map1[i][j] = str.charAt(j);
                map2[i][j] = str.charAt(j);
                if (map2[i][j] == 'G') map2[i][j] = 'R';
            }
        }

        person1 = 0;
        person2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map1[i][j] != 'O') {
                    person1++;
                    bfs1(i, j, map1[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map2[i][j] != 'O') {
                    person2++;
                    bfs2(i, j, map2[i][j]);
                }
            }
        }

        StringBuilder stb = new StringBuilder();
        stb.append(person1).append(' ').append(person2);
        System.out.println(stb);
    }

    private static void bfs1(int y, int x, char c) {
        Queue<Position> queue = new ArrayDeque<>();

        map1[y][x] = 'O';
        queue.offer(new Position(y, x));

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int newY = now.y + dy[k];
                int newX = now.x + dx[k];

                if (newY < 0 || newX < 0 || newY >= n || newX >= n) continue;
                if (map1[newY][newX] != c) continue;

                map1[newY][newX] = 'O';
                queue.offer(new Position(newY, newX));
            }
        }
    }

    private static void bfs2(int y, int x, char c) {
        Queue<Position> queue = new ArrayDeque<>();

        map2[y][x] = 'O';
        queue.offer(new Position(y, x));

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int newY = now.y + dy[k];
                int newX = now.x + dx[k];

                if (newY < 0 || newX < 0 || newY >= n || newX >= n) continue;
                if (map2[newY][newX] != c) continue;

                map2[newY][newX] = 'O';
                queue.offer(new Position(newY, newX));
            }
        }
    }
}

class Position {
    int y;
    int x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
