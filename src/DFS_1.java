public class DFS_1 {
    public void dfs(int n){
        if(n==0) return;
        else{
            dfs(n-1);
            System.out.print(n);
        }
    }
    public static void main(String[] args) {
        DFS_1 T = new DFS_1();
        T.dfs(3);
    }
}
