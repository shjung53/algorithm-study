package programmers.레벨1;

import java.util.ArrayList;
import java.util.Collections;

public class level1_hallOfFame {
    class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            ArrayList<Integer> hof = new ArrayList<>();

            for(int i=0; i<score.length;i++){
                if(hof.size()<k){
                    hof.add(score[i]);
                    Collections.sort(hof);
                    answer[i]=hof.get(0);
                    continue;
                }

                hof.add(score[i]);
                Collections.sort(hof);
                hof.remove(0);
                answer[i] = hof.get(0);
            }



            return answer;
        }
    }
}
