package programmers.레벨1;

public class level1_keyboard {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];

            for(int i=0; i<targets.length; i++){
                for(char c: targets[i].toCharArray()){
                    int min = 101;
                    for(String str: keymap){
                        if(str.indexOf(c)<0){
                            continue;
                        }else{
                            if(str.indexOf(c)+1<min){
                                min = str.indexOf(c)+1;
                            }
                        }
                    }

                    if(min==101){
                        answer[i] = -1;
                        break;
                    }else{
                        answer[i] += min;
                    }
                }
            }


            return answer;
        }
    }
}
