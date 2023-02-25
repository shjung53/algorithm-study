package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class level1_report {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            HashMap<String, Integer> reportCount = new HashMap<>();
            HashMap<String, Integer> getMail = new HashMap<>();

            HashSet<String> noDuplicated = new HashSet<>(Arrays.asList(report));

            for(String r: noDuplicated){
                String reportedId = r.split(" ")[1];
                reportCount.put(reportedId, reportCount.getOrDefault(reportedId,0)+1);
            }

            for(String r: noDuplicated){
                String reportId = r.split(" ")[0];
                String reportedId = r.split(" ")[1];
                if(reportCount.get(reportedId)>=k){
                    getMail.put(reportId, getMail.getOrDefault(reportId,0)+1);
                }
            }

            for(int i=0; i<id_list.length; i++){
                answer[i] = getMail.getOrDefault(id_list[i],0);
            }

            return answer;
        }
    }
}
