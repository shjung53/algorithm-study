package baekjoon.AB;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static long a, b, count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        count = 0;
        boolean success = false;

        Queue<Long> queue = new ArrayDeque<>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                long number = queue.poll();
                if (number == b) {
                    success = true;
                }
                if (number * 2 <= b) queue.offer(number * 2);
                if (number * 10 + 1 <= b) queue.offer(number * 10 + 1);
            }

            count++;

            if (success) break;
        }

        if (!success) count = -1;

        System.out.println(count);
    }
}
