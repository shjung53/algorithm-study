package baekjoon.보물_1026;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int[] A, B;
    static int n, answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        A = new int[n];
        B = new int[n];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> aQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        PriorityQueue<Integer> bQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i=0; i<n; i++) {
            aQueue.add(A[i]);
            bQueue.add(B[i]);
        }

        while(!aQueue.isEmpty()) {
            answer += aQueue.poll() * bQueue.poll();
        }

        System.out.println(answer);


    }
}
