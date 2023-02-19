package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class SQ_2 {
    public String solution(String str){
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char x: str.toCharArray()){
//            pop 한 값이'('가 아니면 반복
            if(x ==')') {
                while (stack.pop() != '(');
            }else{
                stack.push(x);
            }
        }
//        answer에 남은 char 추가
        for(int i=0; i<stack.size(); i++) {
            answer += stack.get(i);
        }


        return answer;
    }

    public static void main(String[] args) {
        SQ_2 T = new SQ_2();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));

    }
}

