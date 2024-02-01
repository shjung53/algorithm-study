import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] map;

    static int n, m, k, count;

    static ArrayList<Integer> area;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        area = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j <= y2 - 1; j++) {
                for (int l = x1; l <= x2 - 1; l++) {
                    map[j][l]++;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    count = 0;
                    bfs(i, j);
                }
            }
        }

        area.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        StringBuilder stb = new StringBuilder();
        stb.append(area.size()).append('\n');
        for (int count : area) {
            stb.append(count).append(' ');
        }
        System.out.println(stb);
    }

    static void bfs(int y, int x) {
        Queue<Position> queue = new ArrayDeque<>();
        map[y][x]++;
        count++;
        queue.offer(new Position(y, x));

        while (!queue.isEmpty()) {
            Position now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int newY = now.y + dy[k];
                int newX = now.x + dx[k];

                if (newY < 0 || newX < 0 || newY >= m || newX >= n) continue;
                if (map[newY][newX] > 0) continue;
                map[newY][newX]++;
                count++;
                queue.offer(new Position(newY, newX));
            }
        }

        area.add(count);
    }
}

class Position {
    int y, x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
