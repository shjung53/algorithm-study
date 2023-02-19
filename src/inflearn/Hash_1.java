package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Hash_1 {

    public Character solution(int n, String str){
        Character leader = ' ';

        HashMap<Character,Integer> vote = new HashMap<>();

        for(char x: str.toCharArray()){
            vote.put(x, vote.getOrDefault(x, 0)+1);
        }

        int max = Integer.MIN_VALUE;

        for(char key: vote.keySet()){
            if(vote.get(key) > max){
                max = vote.get(key);
                leader = key;
            }
        }

        return leader;
    }


    public static void main(String[] args) {
        Hash_1 T = new Hash_1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.print(T.solution(n,str));
    }
}
