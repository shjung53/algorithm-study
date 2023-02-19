package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class SQ_3 {
    public int solution(int n, int[][]board, int m, int[] moves){
        int answer = 0;
        Stack<Integer> basket = new Stack<Integer>();

        for(int x: moves){
            int i=0;
            int check=0;
            while(board[i][x]==0){
                i++;
                if(i==n)break;
            }
            if(i==n) continue;
            if(basket.isEmpty()){
                basket.push(board[i][x]);
                board[i][x] =0;
                continue;
            }else{
                check = basket.pop();
            }
            if(check != board[i][x]){
                basket.push(check);
                basket.push(board[i][x]);
                board[i][x] =0;
            }else{
                answer += 2;
                board[i][x] =0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SQ_3 T = new SQ_3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n+1];
        for(int i=0; i<n; i++){
            for(int j=1; j<n+1; j++){
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for(int i=0; i<m; i++){
            moves[i] = kb.nextInt();
        }

        System.out.print(T.solution(n,board,m,moves));
    }
}
