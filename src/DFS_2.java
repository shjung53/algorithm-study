public class DFS_2 {
    public void dfs(int n){
        if(n==0) return;
        else{
            dfs(n/2);
            System.out.print(n%2);
        }
    }
    public static void main(String[] args) {
        DFS_2 T = new DFS_2();
        T.dfs(11);
    }
}

