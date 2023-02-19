package inflearn;

import java.util.Scanner;

public class Efficiency_6 {
    public int solution(int n, int k, int[] arr){
        int answer=0, lt=0, count=0;

        for(int rt=0; rt<n; rt++){

            if(arr[rt]==0)count++;
            while(count>k){
                if(arr[lt]==0) count--;
                lt++;
            }
            if(answer< rt-lt+1){
                answer= rt-lt+1;
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        Efficiency_6 T = new Efficiency_6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k= kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(n,k,arr));
    }
}
