package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Sort_5 {
    public char solution(int n, int[] arr){
        char answer='U';
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i])>1){
                answer='D';
                break;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Sort_5 T = new Sort_5();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        System.out.print(T.solution(n,arr));
    }
}
