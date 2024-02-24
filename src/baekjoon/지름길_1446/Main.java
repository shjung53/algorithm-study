package baekjoon.지름길_1446;

import java.util.*;
import java.io.*;

public class Main {
    static int n, totalDistance;
    static BufferedReader br;
    static StringTokenizer st;

    static int[] visited;

    static ArrayList<ShortCut>[] shortCuts;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        totalDistance = Integer.parseInt(st.nextToken());
        shortCuts = new ArrayList[totalDistance + 1];
        visited = new int[totalDistance + 1];

        for (int i = 0; i <= totalDistance; i++) {
            shortCuts[i] = new ArrayList<>();
            visited[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if(start > totalDistance) continue;
            shortCuts[start].add(new ShortCut(start, end, length));
        }

        Queue<Position> queue = new ArrayDeque<>();

        queue.offer(new Position(0, 0));

        while (!queue.isEmpty()) {
            Position now = queue.poll();
            if (now.distance > visited[now.pos]) continue;
            visited[now.pos] = now.distance;

            for (ShortCut shortCut : shortCuts[now.pos]) {
                if (shortCut.end > totalDistance) continue;
                if (visited[shortCut.end] < now.distance + shortCut.length) continue;
                visited[shortCut.end] = now.distance + shortCut.length;
                queue.offer(new Position(shortCut.end, now.distance + shortCut.length));
            }

            if (now.pos >= totalDistance) continue;

            if (visited[now.pos + 1] < now.distance + 1) continue;
            queue.offer(new Position(now.pos + 1, now.distance + 1));
        }

        System.out.println(visited[totalDistance]);

    }
}

class Position {
    int pos, distance;

    public Position(int pos, int distance) {
        this.pos = pos;
        this.distance = distance;
    }
}

class ShortCut {
    int start, end, length;

    public ShortCut(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}
