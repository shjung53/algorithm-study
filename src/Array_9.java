import java.util.Scanner;

public class Array_9 {
    public int solution(int n, int[][]panel){
        int largest=0, sum1=0, sum2 =0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sum1 += panel[i][j];
                sum2 += panel[j][i];
            }
            largest = Math.max(largest, sum1);
            largest = Math.max(largest, sum2);
            sum1=0;
            sum2=0;
        }
        for(int i=0; i<n; i++){
            sum1 += panel[i][i];
            sum2 += panel[n-1-i][i];
        }
        largest = Math.max(largest, sum1);
        largest = Math.max(largest, sum2);



        return largest;
    }

    public static void main(String[] args) {
        Array_9 T = new Array_9();
        Scanner kb = new Scanner(System.in);
        int n= kb.nextInt();
        int[][] panel = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                panel[i][j] = kb.nextInt();
            }
        }
        System.out.print(T.solution(n, panel));

    }
}
