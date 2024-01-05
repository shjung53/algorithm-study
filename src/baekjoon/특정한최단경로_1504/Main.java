package baekjoon.특정한최단경로_1504;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Main {
    static int n, e, stopOver1, stopOver2;
    static BufferedReader br;
    static StringTokenizer st;
    static Node[] nodes;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            nodes[a].links.add(new Line(b, distance));
            nodes[b].links.add(new Line(a, distance));
        }

        st = new StringTokenizer(br.readLine().trim());

        stopOver1 = Integer.parseInt(st.nextToken());
        stopOver2 = Integer.parseInt(st.nextToken());

        long answer1 = 0;
        long answer2 = 0;

        int startToS1 = getShortest(1, stopOver1);
        int startToS2 = getShortest(1, stopOver2);
        int S1ToS2 = getShortest(stopOver1, stopOver2);
        int S1ToEnd = getShortest(stopOver1, n);
        int S2ToEnd = getShortest(stopOver2, n);

        answer1 += startToS1;
        answer1 += S1ToS2;
        answer1 += S2ToEnd;

        answer2 += startToS2;
        answer2 += S1ToS2;
        answer2 += S1ToEnd;

        long answer = Math.min(answer1, answer2);
        if (answer >= Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

    private static int getShortest(int start, int end) {
        visited = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            visited[i] = Integer.MAX_VALUE;
        }

        Queue<Move> queue = new ArrayDeque<>();

        visited[start] = 0;
        queue.offer(new Move(start, 0));

        while (!queue.isEmpty()) {
            Move move = queue.poll();
            Node node = nodes[move.position];

            for (Line line : node.links) {
                int next = line.to;
                if (visited[next] > move.movement + line.distance) {
                    visited[next] = move.movement + line.distance;
                    queue.offer(new Move(next, move.movement + line.distance));
                }
            }
        }

        return visited[end];
    }

}

class Move {
    int position;
    int movement;

    public Move(int position, int movement) {
        this.position = position;
        this.movement = movement;
    }
}

class Node {
    ArrayList<Line> links = new ArrayList<>();
}

class Line {
    int to;
    int distance;

    public Line(int to, int distance) {
        this.to = to;
        this.distance = distance;
    }
}
