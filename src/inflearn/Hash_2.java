package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Hash_2 {
    public String solution(String str1, String str2){
        boolean anagram = true;
        String answer ="";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(char x: str1.toCharArray()){
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        for(char x: str2.toCharArray()){
            map2.put(x, map2.getOrDefault(x, 0)+1);
        }

        for(char key: map1.keySet()){
            if(map2.get(key) != map1.getOrDefault(key,0)){
                anagram = false;
            }
        }
        if(anagram){answer = "YES";
        }else{
            answer="NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Hash_2 T = new Hash_2();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.nextLine();
        String str2 = kb.nextLine();
        System.out.print(T.solution(str1, str2));
    }
}
