import java.util.Scanner;

public class Array_10 {
    public int solution(int n, int[][] field){
        int[] dx ={1,-1,0,0};
        int[] dy ={0,0,1,-1};
        int peak =0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                boolean flag = true;
                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nx>=0 && nx<n && ny>=0 && ny<n && field[nx][ny]>=field[i][j]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    peak++;
                }
            }
        }


        return peak;
    }

    public static void main(String[] args) {
        Array_10 T = new Array_10();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] field = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                field[i][j] = kb.nextInt();
            }
        }
        System.out.print(T.solution(n, field));
    }
}
