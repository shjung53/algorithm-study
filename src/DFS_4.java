public class DFS_4 {

    static int[] fibo;
    public int DFS_4(int n){
        if(fibo[n]>0) return fibo[n];
        if(n==1) return fibo[n]=1;
        else if(n==2) return fibo[n]=1;
        else return fibo[n] = DFS_4(n-2) + DFS_4(n-1);
    }

    public static void main(String[] args) {
        DFS_4 T = new DFS_4();
        int n= 45;
        fibo = new int[n+1];
        T.DFS_4(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i]+" ");
    }

}
