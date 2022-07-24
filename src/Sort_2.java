import java.util.Scanner;

public class Sort_2 {

    public int[] solution(int n, int[] arr) {

        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int bigger = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = bigger;
                }
            }

        }


        return arr;
    }

    public static void main(String[] args) {
        Sort_2 T = new Sort_2();
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
