package inflearn;

import java.util.Scanner;

public class Sort_3 {

    public int[] solution(int n, int[] arr) {

        for(int i=1; i<n; i++){
            int insert = arr[i];
            for(int j=i-1; j>=0; j--){
                if(arr[j]>insert){
                    arr[j+1] = arr[j];
                    arr[j] = insert;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Sort_3 T = new Sort_3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}

