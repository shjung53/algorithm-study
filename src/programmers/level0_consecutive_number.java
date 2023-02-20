package programmers;

public class level0_consecutive_number {
    class Solution {
        public int[] solution(int num, int total) {
            int[] answer = new int[num];
            int middle;
            int min;

            if((num&1) == 1){
                middle = total/num;
                min = middle -((num-1)/2);
                for(int i=min;i<min+num;i++){
                    answer[i-min] = i;
                }
            }else{
                middle = total/num;
                min = middle - ((num/2)-1);
                for(int i=min;i<min+num;i++){
                    answer[i-min] = i;
                }
            }
            return answer;
        }
    }
}
