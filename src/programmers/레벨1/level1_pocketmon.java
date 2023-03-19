package programmers.레벨1;

import java.util.HashSet;

public class level1_pocketmon {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;

            HashSet<Integer> kind = new HashSet<>();

            for(int num: nums){
                kind.add(num);
            }

            if(kind.size()>nums.length/2){
                answer = nums.length/2;
            }else{
                answer = kind.size();
            }

            return answer;
        }
    }
}
