package inflearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hash_3 {
    public ArrayList<Integer> solution(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
//        인덱스 0~2까지
        for(int i=0; i<k-1; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        int lt=0;
//        인덱스 3 넣고 정답에 추가
        for(int rt=k-1; rt<n; rt++){
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
            answer.add(map.keySet().size());
//            첫번째 인덱스 키 감소하거나 중복 아닐 시 제거
            map.put(arr[lt], map.get(arr[lt])-1);
            if(map.get(arr[lt])<1){
                map.remove(arr[lt]);
            }
            lt++;
        }


        return answer;
    }








    public static void main(String[] args) {
        Hash_3 T = new Hash_3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        for(int x: T.solution(n,k,arr)){
            System.out.print(x+" ");
        }
    }
}
