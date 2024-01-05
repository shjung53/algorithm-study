package baekjoon.트럭_13335;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n, w, l;
    static int[] weights;
    static int[] pos; // 트럭들의 포지션 0은 아직 진입 x, 1~w까지는 다리 위, w+1 부터는 다리를 지나간 상태
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        weights = new int[n];
        pos = new int[n];

        st = new StringTokenizer(br.readLine().trim());

        for(int i=0; i<n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int totalWeight = 0;
        int time = 0;
        int index =0;

        Queue<Integer> queue = new ArrayDeque<Integer>(); // 인덱스를 넣는다.
        queue.offer(index);
        time++;
        index++;

        while(!queue.isEmpty()) {
            if(totalWeight + weights[index] <= w) {
                int frontIndex = queue.peek(); // 맨 앞에 있는 트럭 인덱스
                for(int truckIdx = frontIndex; truckIdx < index; truckIdx++) {
                    pos[truckIdx] ++; // 다리 위 모든 트럭 한칸씩 이동
                }
                if(pos[frontIndex] > w) {
                    queue.poll();
                    totalWeight -= weights[frontIndex];
                }
                queue.offer(index);
                time++;
                totalWeight += weights[index];
                index++;
            } else {
                while(totalWeight + weights[index] > w) {
                    int frontIndex = queue.poll(); // 맨 앞에 있는 트럭 인덱스
                    int frontOutTime = w + 1 -pos[frontIndex]; // 맨 앞에 있는 트럭이 이동해야 하는 거리
                    for(int truckIdx = frontIndex; truckIdx < index; truckIdx++) {
                        pos[truckIdx] += frontIndex; // 다리 위 모든 트럭 이동
                    }
                    time += frontOutTime; // 시간 반영
                }
                queue.offer(index);
            }
        }
    }
}
