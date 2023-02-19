package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class SQ_5 {
    public int solution(String str){
        int piece=0, stick=0;
        char pre =' ';
        Stack<Character> stack = new Stack<>();

        for(char x: str.toCharArray()){
            if(x=='('){
                if(pre==' '){
                    pre = x;
                } else if (pre=='(') {
                    stick++;
                    piece++;
                    pre=x;
                }else{
                    pre=x;
                }
            }else{
                if(pre=='('){
                    piece += stick;
                    pre=x;
                }else{
                    stick--;
                    pre=x;
                }
            }
        }


        return piece;
    }

    public static void main(String[] args) {
        SQ_5 T = new SQ_5();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }
}
