package baekjoon.트리_4803;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n, m, treeCount;
    static int[] parent;
    static int[] rank;

    static HashSet<Integer> roots, cycle;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = 1;

        while(true) {
            st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;
            treeCount = 0;

            parent = new int[n + 1];
            rank = new int[n + 1];

            for(int i=1; i<=n; i++) {
                parent[i] = i;
            }

            roots = new HashSet<>();
            cycle = new HashSet<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (!union(a, b)) cycle.add(a);
            }


            for (int i = 1; i <= n; i++) {
                if(parent[i] == i) roots.add(parent[i]);
            }

            Loop:
            for (int treeRoot : roots) {
                for (int cycleNode : cycle) {
                    if (parent[cycleNode] == treeRoot) continue Loop;
                }
                treeCount++;
            }

            if (treeCount == 0) {
                System.out.println("Case " + testCase + ": No trees.");
            } else if (treeCount == 1) {
                System.out.println("Case " + testCase + ": There is one tree.");
            } else {
                System.out.println("Case " + testCase + ": A forest of " + treeCount+ " trees.");
            }

            testCase++;
        }

    }

    private static int findParent(int child) {
        if (parent[child] == child) return child;

        return parent[child] = findParent(parent[child]);
    }

    private static boolean union(int a, int b) {
        int pA = findParent(a);
        int pB = findParent(b);

        if (pA == pB) return false;

        if (rank[pA] < rank[pB]) {
            int temp = pA;
            pA = pB;
            pB = temp;
        }

        rank[pA]++;
        parent[pB] = pA;
        return true;
    }
}
