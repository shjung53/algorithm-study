package inflearn;

import java.util.Scanner;

public class DFS_BFS_1 {
    String answer = "No";
    static int n, total=0;
    boolean flag=false;

    public void DFS(int L, int sum, int[] arr){
        if(flag == true) return;
        if(L == n){
            if((total-sum)==sum){
                answer = "true";
                flag = true;
            }
        }else{
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }

    }
    public static void main(String[] args) {
        DFS_BFS_1 T = new DFS_BFS_1();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        T.DFS(0,0, arr);
    }
}
