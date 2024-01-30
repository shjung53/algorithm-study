import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int r, c, k, answer, distance;

    static char[][] map;
    static boolean[][] visited;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        answer = 0;
        distance = 1;
        visited[r - 1][0] = true;
        dfs(r - 1, 0);

        System.out.println(answer);
    }

    private static void dfs(int y, int x) {

        if (y == 0 && x == c - 1) {
            if (distance == k) answer++;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int newY = y + dy[k];
            int newX = x + dx[k];

            if (newY < 0 || newX < 0 || newY >= r || newX >= c) continue;
            if (map[newY][newX] == 'T' || visited[newY][newX]) continue;
            visited[newY][newX] = true;
            distance++;
            dfs(newY, newX);
            visited[newY][newX] = false;
            distance--;
        }
    }
}
