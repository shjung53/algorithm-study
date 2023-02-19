package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SQ_7 {
    public String solution(String order, String str){
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for(char x: order.toCharArray()){
            q.offer(x);
        }

        for(char x: str.toCharArray()){
            if(q.peek() != x) continue;
            if(q.size()>0){
                q.poll();
            }else{
                break;
            }
            if(q.size()==0) break;
        }
        if(q.size()>0) answer = "NO";

        return answer;
    }

    public static void main(String[] args) {
        SQ_7 T = new SQ_7();
        Scanner kb = new Scanner(System.in);
        String order = kb.next();
        String str = kb.next();
        System.out.print(T.solution(order, str));
    }
}
