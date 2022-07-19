import java.util.ArrayList;
import java.util.Scanner;

public class Array_4 {
    public ArrayList<Integer> solution(int n){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(0,1);
        answer.add(1,1);
        for(int i=2; i<n; i++){
            answer.add(i, answer.get(i - 1) + answer.get(i - 2));
        }


        return answer;
    }

    public static void main(String[] args) {
        Array_4 T = new Array_4();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int x : T.solution(n)){
            System.out.print(x + " ");
        }
    }
}
