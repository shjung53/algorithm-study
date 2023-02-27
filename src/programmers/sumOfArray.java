package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class sumOfArray {

    class Solution {
        public ArrayList<Integer> solution(int[] numbers) {
            ArrayList<Integer> answer = new ArrayList<>();
            HashSet<Integer> sum = new HashSet<Integer>();
            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0; i<numbers.length-1; i++){
                for(int j=i+1; j<numbers.length; j++){
                    sum.add(numbers[i]+numbers[j]);
                }
            }

            for(int i:sum){
                answer.add(i);
            }
            Collections.sort(answer);
            return answer;
        }
    }
}
