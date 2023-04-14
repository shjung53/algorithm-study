package inflearn.first;

import java.util.Scanner;

public class Array_7 {

    public int solution(int n, int[] omr){
        int score =0, count =0;

        for(int i=0; i<n; i++){
            if(omr[i] == 1){
                count += 1;
                score += count;
            }else{
                count =0;
            }
        }


        return score;
    }

    public static void main(String[] args) {
        Array_7 T = new Array_7();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] omr = new int[n];
        for(int i=0; i<n; i++){
            omr[i] = kb.nextInt();
        }
        System.out.print(T.solution(n, omr));

    }

}
