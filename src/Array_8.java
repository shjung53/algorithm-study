import java.util.Scanner;

public class Array_8 {
    public int[] solution(int n, int[] students){
        int[] ranks = new int[n];
        int rank =1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(students[i] < students[j]){
                    rank++;
                }
            }
            ranks[i] = rank;
            rank = 1;
        }

        return ranks;
    }

    public static void main(String[] args) {
        Array_8 T = new Array_8();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] students = new int[n];
        for(int i=0; i<n; i++){
            students[i] = kb.nextInt();
        }
        for(int x: T.solution(n, students)){
            System.out.print(x+" ");
        }
    }
}
