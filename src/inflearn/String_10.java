package inflearn;

import java.util.Scanner;

public class String_10 {
    public int[] solution(String str, char c){
        int length = str.length();
        int[] answer = new int[length];
        int p=1000;
        for(int i=0; i<length;i++){
            if(str.charAt(i)==c){
                p=0;
                answer[i]=p;
            }else{
                p++;
                answer[i]=p;
            }
        }
        p=1000;
        for(int j=length-1; j>=0; j--){
            if(str.charAt(j)==c){
                p=0;
                answer[j]=p;
            }else{
                p++;
                if(p<answer[j]){
                    answer[j]=p;
                }
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
