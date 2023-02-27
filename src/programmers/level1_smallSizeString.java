package programmers;

import java.math.BigInteger;

public class level1_smallSizeString {
    static class Solution {
        public int solution(String t, String p) {
            int answer = 0;
            int size = p.length();

            for(int i=0; i<t.length()-size+1; i++){
                String frag = t.substring(i,i+size);
                if(frag.replaceAll("0", "").equals("")){
                    frag="0";
                }else{
                    for(int j=0; j<frag.length(); j++){
                        if(frag.charAt(j)!='0'){
                            frag=frag.substring(j);
                            break;
                        }
                    }
                }
                Long bigT = Long.parseLong(frag);
                Long bigP = Long.parseLong(p);
                if(bigT.compareTo(bigP)<1){
                    answer++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args){
        Solution t = new Solution();
        t.solution("13462747285800497097002903296","8206326298");
    }
}
