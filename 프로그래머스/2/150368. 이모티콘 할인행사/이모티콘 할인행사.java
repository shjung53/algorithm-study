import java.util.*;

class Solution {
    static int[] emojiDiscounts;
    static int[] discounts = {10, 20, 30, 40};
    static int[][] myUsers;
    static int[] myEmoticons;
    static int memberCount;
    static int emojiProfit;
    static int answerMemberCount;
    static int answerEmojiProfit;
    
    public int[] solution(int[][] users, int[] emoticons) {
        emojiDiscounts = new int[emoticons.length];
        myUsers = users;
        myEmoticons = emoticons;
        answerMemberCount = 0;
        answerEmojiProfit = 0;
        
        setDiscount(0);
        
        int[] answer = {answerMemberCount, answerEmojiProfit};
        
        return answer;
    }
    
    private static void setDiscount(int idx) {
        if(idx >= emojiDiscounts.length) {
            memberCount = 0;
            emojiProfit = 0;
            for(int userIdx=0; userIdx < myUsers.length; userIdx++) {
                int payment = 0;
                for(int emojiIdx = 0; emojiIdx < emojiDiscounts.length; emojiIdx++) {
                    if(myUsers[userIdx][0] <= emojiDiscounts[emojiIdx]) {
                        payment += (myEmoticons[emojiIdx] * (100 - emojiDiscounts[emojiIdx])) / 100;}
                }
                if(payment >= myUsers[userIdx][1]) {
                    memberCount++;
                } else {
                    emojiProfit += payment;
                }
            }
            
            if(memberCount > answerMemberCount) {
                answerMemberCount = memberCount;
                answerEmojiProfit = emojiProfit;
            }else if(memberCount == answerMemberCount) {
                if(emojiProfit > answerEmojiProfit) {
                    answerEmojiProfit = emojiProfit;
                }
            }
            return;
        }
        
        for(int discount : discounts){
            emojiDiscounts[idx] = discount;
            setDiscount(idx + 1);
        }
    }
}