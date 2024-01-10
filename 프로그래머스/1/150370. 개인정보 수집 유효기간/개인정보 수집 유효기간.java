import java.util.*;

class Solution {
    static int[] answer;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answerArr = new ArrayList<Integer>();
        
        // 현재 날짜 분리하기
        int nowYear = Integer.parseInt(today.substring(0, 4));
        int nowMonth = Integer.parseInt(today.substring(5, 7));
        int nowDay = Integer.parseInt(today.substring(8));
        
        HashMap<Character, Integer> termsMap = new HashMap<>();
        
        // 약관 종류 맵에 모두 넣기
        for(String termStr : terms) {
            String[] termArr = termStr.split(" ");
            Character termName = termStr.charAt(0);
            int termLength = Integer.parseInt(termArr[1]);
            termsMap.put(termName, termLength);
        }
        
        for(int idx = 0; idx<privacies.length; idx++) {
            String privacy = privacies[idx];
            String date = privacy.substring(0, 10);
            Character term = privacy.charAt(11);
            int privacyYear = Integer.parseInt(date.substring(0, 4));
            int privacyMonth = Integer.parseInt(date.substring(5, 7));
            int privacyDay = Integer.parseInt(date.substring(8, 10));
            
            // 유효기간
            int length = termsMap.get(term);
            
            // 유효기간이 몇년인지
            int yearDiff = length / 12;
            
            // 남은 달 수
            int monthDiff = length % 12;
            
            // 여유 기간
            int targetYear = privacyYear + yearDiff;
            
            int targetMonth = privacyMonth + monthDiff;
            
            int targetDay = privacyDay - 1;
            
            if(targetMonth > 12) {
                targetYear += 1;
                targetMonth -= 12;
            }
            
            if(targetYear < nowYear) {answerArr.add(idx + 1); continue;}
            if(targetYear == nowYear && targetMonth < nowMonth) {answerArr.add(idx + 1); continue;}
            if(targetYear == nowYear && targetMonth == nowMonth && targetDay < nowDay){
                answerArr.add(idx + 1);
                continue;
            }
        }
        
        answer = new int[answerArr.size()];
        
        for(int idx = 0; idx< answerArr.size(); idx++) {
            answer[idx] = answerArr.get(idx);
        }
        
        return answer;
    }
}