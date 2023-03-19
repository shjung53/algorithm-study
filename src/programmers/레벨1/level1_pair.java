package programmers.레벨1;

import java.util.HashMap;

public class level1_pair {
    static class Solution {
        public String solution(String X, String Y) {
            StringBuilder answer = new StringBuilder();

            HashMap<Character,Integer> mapX = new HashMap<>();
            HashMap<Character,Integer> mapY = new HashMap<>();
            HashMap<Character,Integer> numbers = new HashMap<>();

            for(char x: X.toCharArray()){
                mapX.put(x,mapX.getOrDefault(x,0)+1);
            }
            for(char y: Y.toCharArray()){
                mapY.put(y,mapY.getOrDefault(y,0)+1);
            }

            for(char x: X.toCharArray()){
                if(mapY.get(x)!=null && mapY.get(x)>0){
                    numbers.put(x,Math.min(mapX.get(x), mapY.get(x)));
                }
            }

            if(numbers.keySet().size()==0){
                return "-1";
            }else{
                if(numbers.keySet().size()==1 && numbers.keySet().contains('0')){
                    return "0";
                }
            }

            for(int i=57; i>=48; i--){
                if(numbers.get((char)i)!=null && numbers.get((char)i)>0){
                    int size = numbers.get((char)i);
                    for(int j=0; j<size; j++){
                        answer.append((char) i);
                    }
                }
            }

            return answer.toString();
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.print(s.solution("100","203045"));
    }
}
