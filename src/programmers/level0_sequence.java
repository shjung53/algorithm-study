package programmers;

public class level0_sequence {
    class Solution {
        public int solution(int[] common) {
            int answer = 0;
            int size = common.length;
            String type= "arith";

            if(common[0] == common[1]){
                answer = common[0];
                return answer;
            }

            for(int i=0; i<size-2; i++){
                if(common[i+2]-common[i+1] != common[i+1] - common[i]){
                    type = "geo";
                    break;
                }
            }

            if(type == "arith"){
                answer = common[size-1] + (common[1]-common[0]);
            }else{
                answer = common[size-1] * (common[1]/common[0]);
            }
            return answer;
        }
    }
}
