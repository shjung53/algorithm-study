package programmers;

public class level1_cola {
    class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;
            int left=n;

            while(left>=a){
                answer += (left/a)*b;
                left = left%a + (left/a)*b;
            }



            return answer;
        }
    }
}
