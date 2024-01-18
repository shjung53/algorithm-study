package baekjoon.트럭_13335;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n, w, l, totalWeight, time;
    static int[] weights;

    static Queue<Integer> queue;
    static Queue<Integer> bridge;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        weights = new int[n + 1];

        st = new StringTokenizer(br.readLine().trim());

        for(int i=1; i<=n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        totalWeight = 0;
        time = 0;

        queue = new ArrayDeque<Integer>(); // 대기 큐.
        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }
        bridge = new ArrayDeque<>();

        for(int i=0; i<w; i++) {
            bridge.offer(0);
        }

        while(!queue.isEmpty()) {
            if(totalWeight - weights[bridge.peek()] + weights[queue.peek()] > l) {
                totalWeight -= weights[bridge.poll()];
                bridge.offer(0);
            } else {
                totalWeight -= weights[bridge.poll()];
                totalWeight += weights[queue.peek()];
                bridge.offer(queue.poll());
            }
            time++;
        }

        while(totalWeight > 0) {
            totalWeight -= weights[bridge.poll()];
            time++;
        }

        System.out.println(time);
    }
}
