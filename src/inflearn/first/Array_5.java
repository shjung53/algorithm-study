package inflearn.first;

import java.util.Scanner;

public class Array_5 {
    public int solution(int n){
        int answer = 0;
        int[] num = new int[n+1];
        for(int i=2; i<n+1; i++){
            if(num[i] ==0){
                answer++;
                for(int j=i; j<n+1; j=j+i){
                    num[j] =1;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Array_5 T = new Array_5();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.print(T.solution(n));
    }
}
