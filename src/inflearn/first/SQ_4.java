package inflearn.first;

import java.util.Scanner;
import java.util.Stack;

public class SQ_4 {

    private int charToInt(char x){
        return Character.getNumericValue(x);
    }

    public int solution(String str){

        Stack<Integer> stack = new Stack<>();
        for(char x: str.toCharArray()){
            if(Character.isDigit(x)){
                stack.push(charToInt(x));
            }else{
                int result=0;
                int b = stack.pop();
                int a = stack.pop();
                switch(x){
                    case '+':
                        result = a+b;
                        break;
                    case '-':
                        result = a-b;
                        break;
                    case '*':
                        result = a*b;
                        break;
                    case '/':
                        result = a/b;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        SQ_4 T = new SQ_4();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }
}
