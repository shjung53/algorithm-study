package programmers;

public class level1_knight {
    class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;

            for(int i=1; i<=number; i++){
                if(measure(i)>limit){
                    answer+=power;
                }else{
                    answer+=measure(i);
                };
            }

            return answer;
        }

        private int measure(int i) {
            int count=0;
            for(int j=1; j*j<=i; j++){
                if(j*j==i){count++;} else if (i%j==0){count+=2;} {
                }
            }
            return count;
        }
    }
}
