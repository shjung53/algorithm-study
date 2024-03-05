package baekjoon.스타트링크_5014;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int f, s, g, u, d;

    static boolean[] visited;

    static boolean success;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new boolean[f + 1];

        Queue<Integer> queue = new ArrayDeque<>();

        visited[s] = true;
        queue.offer(s);

        int count = 0;

        Loop:
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int now = queue.poll();
                if (now == g) {
                    success = true;
                    break Loop;
                }

                if (now - d >= 1) {
                    if (!visited[now - d]) {
                        visited[now - d] = true;
                        queue.offer(now - d);
                    }
                }

                if (now + u <= f) {
                    if (!visited[now + u]) {
                        visited[now + u] = true;
                        queue.offer(now + u);
                    }
                }

            }
            count++;
        }

        if (!success) {
            System.out.println("use the stairs");
        } else {
            System.out.println(count);
        }
    }
}
