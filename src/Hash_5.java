import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Hash_5 {
    public int solution(int n, int k, int[] arr){
        int answer=-1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int l=j+1; l<n; l++){
                    Tset.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        int count=0;
        for(int x: Tset){
            count++;
            if(count==k) answer = x;
        }


        return answer;
    }

    public static void main(String[] args) {
        Hash_5 T = new Hash_5();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        System.out.print(T.solution(n,k,arr));
    }
}
