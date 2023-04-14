package inflearn.first;

import java.util.Scanner;

public class String_8 {
    public String solution(String str){
        String answer= "NO";
        /*알파벳 A-Z까지 아니면 제거 */
        str= str.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) answer = "YES";
        return answer;
    }


    public static void main(String[] args) {
        String_8 T = new String_8();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.print(T.solution(str));
    }
}