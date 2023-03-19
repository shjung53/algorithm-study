package programmers.레벨0;

import java.util.HashMap;

public class level0_frequent {
    class Solution {
        public int solution(int[] array) {
            int answer = -1;
            int size = array.length;
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i=0; i<size;i++){
                map.put(array[i], map.getOrDefault(array[i],0)+1);
            }

            for(int key:map.keySet()){
                if(answer<0){
                    answer = key;
                    continue;
                }
                if(map.get(key)>map.get(answer)){
                    answer = key;
                }
            }

            for(int key: map.keySet()){
                if(map.get(answer) == map.get(key) && answer != key){
                    answer = -1;
                }
            }

            return answer;
        }
    }
}
