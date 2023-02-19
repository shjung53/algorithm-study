package inflearn;

public class DFS_3 {
    public int dfs(int n){
        if(n==1) return 1;
        else return n*dfs(n-1);
    }
    public static void main(String[] args) {
        DFS_3 T = new DFS_3();
        System.out.print(T.dfs(5));
    }
}
