import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, k, answer;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        visited = new int[200001];

        Queue<Number> queue = new ArrayDeque<>();

        for (int i = 0; i < 200001; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
		visited[n] = 0;
        queue.offer(new Number(n, 0));

        while (!queue.isEmpty()) {
            Number number = queue.poll();

            if (number.num == k) {
                if (number.time < answer) answer = number.time;
                continue;
            }


			int next = number.num * 2;

			if (next <= 200000) {
				if (visited[next] > number.time) {
					visited[next] = number.time;
					queue.offer(new Number(next, number.time));
				}
			}

			next = number.num - 1;

            if (next >= 0) {
                if (visited[next] > number.time + 1) {
                    visited[next] = number.time + 1;
                    queue.offer(new Number(next, number.time + 1));
                }
            }

            next = number.num + 1;

            if (next <= 200000) {
                if (visited[next] > number.time + 1) {
                    visited[next] = number.time + 1;
                    queue.offer(new Number(next, number.time + 1));
                }
            }
        }

        System.out.println(answer);
    }
}

class Number {
    int num;
    int time;

    public Number(int num, int time) {
        this.num = num;
        this.time = time;
    }
}
