import java.util.ArrayList;
import java.util.Scanner;


public class Array_3 {
    public ArrayList<String> solution(int n, int[] a, int[]b){
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0; i<n; i++){
            if( a[i] == b[i]){
                answer.add("D");
            } else if (a[i] == 1 && b[i] == 2) {
                answer.add("B");
            } else if (a[i] == 2 && b[i] == 3) {
                answer.add("B");
            } else if (a[i] == 3 && b[i] == 1) {
                answer.add("B");
            } else {
                answer.add("A");
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Array_3 T = new Array_3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            a[i] = kb.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i] = kb.nextInt();
        }
        for(String x : T.solution(n,a,b)){
            System.out.println(x);
        }
    }
}
