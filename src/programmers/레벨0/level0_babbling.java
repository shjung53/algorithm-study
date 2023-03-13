package programmers.레벨0;

import java.util.*;

public class level0_babbling {

    class Solution {
        public String[] availableList = {"aya","ye","woo","ma"};
        public int solution(String[] babbling) {
            int answer = 0;

            int size = babbling.length;

            for(int i=0; i<size; i++){
                String str = babbling[i];

                while(str.length()>0){
                    if(check1(str)){
                        answer++;
                        break;
                    }

                    if(check2(str)>0){
                        str = str.substring(check2(str));
                    }else{
                        break;
                    }
                }


            }
            return answer;
        }

        public boolean check1(String str){
            for(String available: availableList){
                if(str.equals(available)){
                    return true;
                }
            }
            return false;
        }

        public int check2(String str){
            for(int i=0; i<availableList.length; i++){
                if(str.startsWith(availableList[i])){
                    return availableList[i].length();
                }
            }
            return -1;
        }
    }
}
