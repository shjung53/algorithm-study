package baekjoon.외판원순회_2098;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] costMap;
    static boolean[] visited;
    static BufferedReader br;
    static StringTokenizer st;
    static int answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        costMap = new int[n][n];
        visited = new boolean[n];
        answer = Integer.MAX_VALUE;;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                costMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처음 도시는 다시 되돌아 올 수 있기 때문에 방문처리를 하지 않음
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int city, int cost, int line) {
        for (int next = 0; next < n; next++) {

            if (line == n) {
                if (cost < answer)
                    answer = cost;
                return;
            }

            // 마지막 라인이 아닌데 벌써 루트로 돌아오려 하면 패스
            if (line < n - 1 && next == 0)
                continue;

            // 길이 없음
            if (costMap[city][next] == 0)
                continue;

            // 이미 방문한 도시
            if (visited[next])
                continue;

            // 방문 처리
            visited[next] = true;
            dfs(next, cost + costMap[city][next], line + 1);

            // 백트래킹 방문처리 해제
            visited[next] = false;
        }
    }
}

class Route {
    int from, to, cost;

    public Route(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
