import java.util.ArrayList;
import java.util.Scanner;

public class Efficiency_1 {
    public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1= 0, p2=0;

        while(p1<n && p2<m){
            if(arr1[p1] < arr2[p2]){
                answer.add(arr1[p1]);
                p1++;
            } else{
                answer.add(arr2[p2]);
                p2++;
            }
        }
        while(p1<n) answer.add(arr1[p1++]);
        while(p2<m) answer.add(arr2[p2++]);

        return answer;
    }


    public static void main(String[] args) {
        Efficiency_1 T = new Efficiency_1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for(int j=0; j<m; j++){
            arr2[j] = kb.nextInt();
        }
        for(int x: T.solution(n,arr1,m,arr2)){
            System.out.print(x+ " ");
        }
    }
}
