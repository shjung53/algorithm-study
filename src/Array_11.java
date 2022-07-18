import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Array_11 {
    public int solution(int n, int[][]students){
        int leader = 0;
        int largest =0;
        int[]friends = new int[n+1];

        for(int i=1; i<n+1; i++){
            HashSet<Integer> count = new HashSet<>();
            for(int k=1; k<6; k++){
                for(int j=1; j<n+1; j++){
                    if(students[i][k] == students[j][k] && i != j){
                        count.add(j);
                    }
                }
            }
            friends[i] = count.size();
        }

        for(int i=1; i<n+1; i++){
            if(friends[i]> largest){
                leader = i;
                largest = friends[i];
            }
        }


        return leader;
    }


    public static void main(String[] args) {
        Array_11 T = new Array_11();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [][] students = new int[n+1][6];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                students[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.solution(n, students));
    }
}
