package programmers;

public class level2_carpet {
    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

//          노란 영역 너비 높이
            int yWidth,yHeight=0;

//          노란 영역 너비 높이 합
//          모서리 영역 제거후 /2
            int sum = (brown-4)/2;

//          노란 영역 너비 높이 곱 == 노란 격자 갯수
            for(int i=1; i<sum; i++){
                yHeight=i;
                yWidth=sum-yHeight;

                if(yWidth * yHeight == yellow){
                    answer[0] = yWidth+2;
                    answer[1] = yHeight+2;
                    break;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution t = new Solution();
        t.solution(24,24);
    }
}
