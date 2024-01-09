import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int[][] map;
    static int count, h, w;
    static int[] dy = {-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] dx = {0, 1, 0, -1, -1, 1, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine().trim());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            count = 0;

            if (h == 0 && w == 0) break;

            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        count++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(int y, int x) {
        Queue<Position> queue = new ArrayDeque<>();

        map[y][x] = 0;
        queue.offer(new Position(y, x));

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];

                if (newY < 0 || newY >= h || newX < 0 || newX >= w)
                    continue;

                if (map[newY][newX] == 0)
                    continue;

                map[newY][newX] = 0;
                queue.offer(new Position(newY, newX));
            }
        }
    }
}

class Position {
    int y, x;

    public Position(int y, int x) {
        super();
        this.y = y;
        this.x = x;
    }

}
