package programmers;

import java.util.*;

public class level1_failRate {
    static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            ArrayList<Stage> stageList = new ArrayList<>();
            int[] userCount = new int[N+1];
            int all = stages.length;
            int before = 0;

            for (int s : stages) {
                if(s>N){continue;}
                userCount[s] = userCount[s]+1;
            }


            for (int i = 1; i <= N; i++) {
                if (userCount[i] == 0) {
                    stageList.add(new Stage(i, 0.0));
                    continue;
                }
                double rate = (double) userCount[i] / (all - before);
                stageList.add(new Stage(i, rate));
                before += userCount[i];
            }

            Arrays.sort(answer);
            stageList.sort(new Comparator<Stage>() {
                @Override
                public int compare(Stage o1, Stage o2) {
                    if(o1.rate==o2.rate){
                        return Double.compare(o1.stageNum,o2.stageNum);
                    }
                    return Double.compare(o2.rate, o1.rate);
                }
            });

            for (int i = 0; i < N; i++) {
                answer[i] = stageList.get(i).stageNum;
            }


            return answer;
        }
    }

    static class Stage {
        final int stageNum;
        double rate;

        public Stage(int stageNum, double rate) {
            this.stageNum = stageNum;
            this.rate = rate;
        }
    }

    public static void main(String[] args) {
        Solution t = new Solution();
        System.out.println(Arrays.toString(t.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }
}
