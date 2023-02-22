package programmers;

import java.util.ArrayList;

public class level1_pw {
    class Solution {

        public Solution(){}
        public static String solution(String s, String skip, int index) {
            String answer = "";

            ArrayList<Character> alphabet = new ArrayList<>();
            for (int i = 97; i < 123; i++) {
                alphabet.add((char) i);
            }
            for (char a : skip.toCharArray()) {
                for (int i = 0; i < alphabet.size(); i++) {
                    if (a == alphabet.get(i)) {
                        alphabet.remove(i);
                    }
                }
            }

            int size = alphabet.size();

            for(char b : s.toCharArray()){
                for(int i=0; i< size; i++){
                    if(b == alphabet.get(i)){
                        int newIndex=i+index;
                        if(newIndex>size-1){
                            while(newIndex>size-1){
                                newIndex-=size;
                            }
                            answer += alphabet.get(newIndex);
                        }else{
                            answer += alphabet.get(newIndex);
                        }
                    }
                }
            }

            System.out.println(answer);

            return answer;
        }
    }

    public static void main(String[]args){
        Solution.solution("qwertz", "abcdefghij", 20);
    }
}
