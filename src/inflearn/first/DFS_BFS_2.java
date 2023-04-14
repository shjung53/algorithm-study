package inflearn.first;

import java.util.Scanner;

public class DFS_BFS_2 {
    static int[] dogs;
    static int limit;
    static int biggest, n = 0;

    public void DFS(int[] dogs, int L, int sum) {
        if (sum > limit) return;
        if (L == n) {
            biggest = Integer.max(sum, biggest);
        } else {

            DFS(dogs, L + 1, sum + dogs[L]);
            DFS(dogs, L + 1, sum);
        }
    }

    public static void main(String[] args) {
        DFS_BFS_2 T = new DFS_BFS_2();
        Scanner kb = new Scanner(System.in);
        limit = kb.nextInt();
        n = kb.nextInt();
        dogs = new int[n];
        for (int i = 0; i < n; i++) {
            dogs[i] = kb.nextInt();
        }
        T.DFS(dogs, 0, 0);
        System.out.print(biggest);
    }
}
