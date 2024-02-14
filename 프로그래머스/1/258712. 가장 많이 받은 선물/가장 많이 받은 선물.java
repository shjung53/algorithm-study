import java.util.*;

class Solution {
    static StringTokenizer st;
    static HashMap<String, Integer> nameMap;
    static int[][] map;
    static int n, answer;
    static int[] point;
    static int[] present;
    
    public int solution(String[] friends, String[] gifts) {
        answer = 0;
        n = friends.length;
        point = new int[n];
        present = new int[n];
        nameMap = new HashMap<String, Integer>();
        
        for(int i=0;i <n; i++) {
            nameMap.put(friends[i], i);
        }
        
        map = new int[n][n];
        
        for(String gift: gifts) {
            st = new StringTokenizer(gift);
            int from = nameMap.get(st.nextToken());
            int to = nameMap.get(st.nextToken());
            point[from]++;
            point[to]--;
            map[from][to]++;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=i + 1; j<n; j++) {
                if(map[i][j] > map[j][i]) {
                    present[i]++;
                    continue;
                }
                
                if(map[j][i] > map[i][j]) {
                    present[j]++;
                }
                
                if(map[i][j] == map[j][i]) {
                    if(point[i] > point[j]) {
                        present[i]++;
                        continue;
                    }
                    
                    if(point[j] > point[i]) {
                        present[j]++;
                        continue;
                    }
                }
                
            }
        }
        
        for(int i=0; i<n; i++) {
            if(answer < present[i]) answer = present[i];
        }
        
        
        return answer;
    }
}