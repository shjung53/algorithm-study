package inflearn.first;

import java.util.Scanner;

public class DFS_BFS_3 {
    static int n, m, maxS;
    static int[] ps, pt;

    public void DFS(int L, int score, int min, int[] ps, int[] pt) {
        if(min>m) return;
        if(L==n){
            maxS = Integer.max(maxS, score);
        }else{
            DFS(L+1, score+ ps[L], min+pt[L], ps, pt);
            DFS(L+1, score, min, ps, pt);
        }
    }


    public static void main(String[] args) {
        DFS_BFS_3 T = new DFS_BFS_3();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        ps = new int[n];
        pt = new int[n];
        for (int i = 0; i < n; i++) {
            ps[i] = kb.nextInt();
            pt[i] = kb.nextInt();
        }
        T.DFS(0, 0, 0, ps, pt);
        System.out.print(maxS);
    }
}
