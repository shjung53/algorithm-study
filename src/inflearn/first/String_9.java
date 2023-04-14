package inflearn.first;

import java.util.Scanner;

public class String_9 {

    public int solution(String str){
        String answer="";
        for(char x: str.toCharArray()){
            if(Character.isDigit(x)){
                answer+=x;
            }
        }

        return Integer.parseInt(answer);
    }


    public static void main(String[] args) {
        String_9 T = new String_9();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.print(T.solution(str));
    }
}
