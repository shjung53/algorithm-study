package programmers.레벨1;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for (int i : d) {
            budget -= i;
            if (budget < 0) {
                return answer;
            }
            answer++;
        }

        return answer;
    }
}
