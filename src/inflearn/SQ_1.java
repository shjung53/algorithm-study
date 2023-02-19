package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class SQ_1 {
    public String solution(String str){
        String answer="YES";
        Stack<Character> stack = new Stack<>();

        for(char x: str.toCharArray()){
            if(x == '('){
                stack.push(x);
            }else if(x==')' && !stack.isEmpty()){
                stack.pop();
            }
            else{
                answer="NO";
            }
        }
        if(!stack.isEmpty()) answer= "NO";

        return answer;
    }

    public static void main(String[] args) {
        SQ_1 T = new SQ_1();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }
}
