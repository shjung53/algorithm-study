package inflearn.first;

import java.util.Scanner;

public class Sort_1 {
    public int[] solution(int n, int[] arr) {

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]>arr[j]){
                    int bigger = arr[i];
                    arr[i] = arr[j];
                    arr[j] = bigger;
                }
            }
        }


        return arr;
    }

    public static void main(String[] args) {
        Sort_1 T = new Sort_1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        for(int x:T.solution(n,arr)){
            System.out.print(x+" ");
        }
    }
}

