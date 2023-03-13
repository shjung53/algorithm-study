package programmers.레벨1;

import java.util.ArrayList;
import java.util.Arrays;

public class level1_cardDeck {
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "No";
            ArrayList<String> cardDeck1 = new ArrayList<>(Arrays.asList(cards1));
            ArrayList<String> cardDeck2 = new ArrayList<>(Arrays.asList(cards2));
            int goalIndex =0;
            int turn;

            if(cardDeck1.get(0).equals(goal[0])){
                turn =1;
            }else if (cardDeck2.get(0).equals(goal[0])){
                turn =2;
            }else{
                return answer;
            }

            while(goalIndex<goal.length){
                if(turn==1){
                    if(cardDeck1.size()<1){
                        return answer;
                    }
                    if(cardDeck1.get(0).equals(goal[goalIndex])){
                        cardDeck1.remove(0);
                        goalIndex++;
                    }else{
                        return answer;
                    }

                    while(cardDeck1.size()>0 && goalIndex<goal.length && cardDeck1.get(0).equals(goal[goalIndex])){
                        cardDeck1.remove(0);
                        goalIndex++;
                    }
                    if(goalIndex==goal.length) return "Yes";
                    turn=2;
                } else {
                    if(cardDeck2.size()<1){
                        return answer;
                    }
                    if(cardDeck2.get(0).equals(goal[goalIndex])){
                        cardDeck2.remove(0);
                        goalIndex++;
                    }else{
                        return answer;
                    }

                    while(cardDeck2.size()>0 && goalIndex<goal.length && cardDeck2.get(0).equals(goal[goalIndex])){
                        cardDeck2.remove(0);
                        goalIndex++;
                    }
                    if(goalIndex==goal.length) return "Yes";
                    turn=1;
                }
            }
            answer = "Yes";
            return answer;
        }
    }
}
