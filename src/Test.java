import java.util.*;


// 겹치는 문자열 중복제거 및 작은 문자열 리턴, 같을 시 사전 빠른순

class Solution {
    public String solution(String s1, String s2) {
        String answer = "";
        String answer1 = "";
        String answer2 = "";
        String a1 = "";
        String a2 = "";
        int duplication1 = 0;
        int duplication2 = 0;

        // 큰 문자열 a1, 작은 문자열 a2
        if(s1.length()>=s2.length()){
            a1 = s1;
            a2 = s2;
        }else{
            a1 = s2;
            a2 = s1;
        }


        // 큰 문자열이 앞에
        for(int i=0; i<a2.length(); i++){
            if(a1.substring(a1.length()-1-i).equals(a2.substring(0,i+1))){
                duplication1 = i+1;
            }
        }

        // 큰 문자열이 뒤에
        for(int i=0; i<a2.length(); i++){
            if(a1.substring(0,i+1).equals(a2.substring(a2.length()-1-i))){
                duplication2 = i+1;
            }
        }

        if(duplication1 > duplication2){
            answer = a1 + a2.substring(duplication1);
        }else if(duplication2 > duplication1){
            answer = a2 + a1.substring(duplication2);
        }else{
            answer1 = a1 + a2.substring(duplication1);
            answer2 = a2 + a1.substring(duplication2);
            if(answer1.compareTo(answer2)>0){
                answer = answer2;
            }else{
                answer = answer1;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Nothing T = new Nothing();
        Scanner kb = new Scanner(System.in);
        String s1 = kb.next();
        String s2 = kb.next();
        System.out.println(T.solution(s1,s2));
    }
}