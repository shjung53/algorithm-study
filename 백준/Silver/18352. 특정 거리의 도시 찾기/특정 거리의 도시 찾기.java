import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n, m, k, x;

    static ArrayList<Road>[] roads;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        roads = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(roads[from] == null) roads[from] = new ArrayList<>();
            roads[from].add(new Road(to));
        }

        Queue<Integer> queue = new ArrayDeque<>();

        visited[x] = true;
        queue.offer(x);

        StringBuilder stb = new StringBuilder();
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int distance = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                int now = queue.poll();
                if(distance == k) pQ.offer(now);

                if(roads[now] == null) continue;
                for(Road road: roads[now]) {
                    if(visited[road.to]) continue;
                    visited[road.to] = true;
                    queue.offer(road.to);
                }
            }
            distance++;
            if(distance > k) break;
        }

        while(!pQ.isEmpty()) {
            stb.append(pQ.poll()).append('\n');
        }

        if(stb.length() < 1) stb.append(-1);

        System.out.println(stb);

    }
}

class Road{
    int to;
    public Road(int to) {
        this.to = to;
    }
}
