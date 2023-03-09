package programmers;

import java.util.HashSet;

public class level2_word_relay {
    static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[] {0,0};

            HashSet<String> usedWord = new HashSet<>();

            for(int i=0; i<words.length; i++){
                if(i==0){
                    usedWord.add(words[i]);
                    continue;}

                if(words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)){
                    answer[0] = i%n+1;
                    answer[1] = i/n+1;
                    break;
                }

                if(usedWord.contains(words[i])){
                    answer[0] = i%n+1;
                    answer[1] = i/n+1;
                    break;
                }

                usedWord.add(words[i]);

            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution t= new Solution();
        t.solution(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
    }
}
