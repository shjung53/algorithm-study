package programmers;

public class level1_nearestChar {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];

            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(s.indexOf(c)==i){
                    answer[i]=-1;
                }
                for(int j=0; j<i; j++){
                    if(s.charAt(j)==c){
                        answer[i]=i-j;
                    }
                }
            }

            return answer;
        }
    }
}
