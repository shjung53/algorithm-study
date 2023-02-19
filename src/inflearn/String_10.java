package inflearn;

import java.util.Scanner;

public class String_10 {
    public int[] solution(String str, char c){
        int[] answer = new int[str.length()];
        int p = 1000;
        char[] s = str.toCharArray();

        for(int i=0; i< s.length; i++){
            if(s[i] == c){
                p=0;
                answer[i]=p;
            }else{
                p++;
                answer[i]=p;
            }
        }
        for(int i= s.length-1; i >=0; i--){
            if(s[i] == c){
                p=0;
            }else{
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }


        return answer;
    }



    public static void main(String[] args) {
        String_10 T = new String_10();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        String[] s = str.split(" ");
        str = s[0];
        char c = s[1].charAt(0);
        for(int x: T.solution(str,c)){
            System.out.print(x + " ");
        }
    }
}
