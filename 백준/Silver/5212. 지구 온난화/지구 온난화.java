import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    static char[][] map;

    static int r, c;

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    static char[][] answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine().trim();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'X') {
                    checkAround(i, j);
                }
            }
        }

        int startY, startX, endY, endX;
        startY = Integer.MAX_VALUE;
        startX = Integer.MAX_VALUE;
        endY = Integer.MIN_VALUE;
        endX = Integer.MIN_VALUE;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'X') {
                    if (i < startY) startY = i;
                    if (j < startX) startX = j;
                    if (i > endY) endY = i;
                    if (j > endX) endX = j;
                }
            }
        }

        int newR = endY - startY + 1;
        int newC = endX - startX + 1;

        answer = new char[newR][newC];

        for (int i = 0; i < newR; i++) {
            for (int j = 0; j < newC; j++) {
                if (map[i + startY][j + startX] == 'x') {
                    answer[i][j] = '.';
                } else {
                    answer[i][j] = map[i + startY][j + startX];
                }
            }
        }

        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < newR; i++) {
            for (int j = 0; j < newC; j++) {
                stb.append(answer[i][j]);
            }
            stb.append('\n');
        }

        System.out.println(stb);

    }

    private static void checkAround(int y, int x) {
        int seaCount = 0;
        for (int k = 0; k < 4; k++) {
            int newY = y + dy[k];
            int newX = x + dx[k];
            if (newY < 0 || newX < 0 || newY >= r || newX >= c) {
                seaCount++;
                continue;
            }
            if (map[newY][newX] == '.') seaCount++;
        }

        if (seaCount >= 3) map[y][x] = 'x';
    }
}
