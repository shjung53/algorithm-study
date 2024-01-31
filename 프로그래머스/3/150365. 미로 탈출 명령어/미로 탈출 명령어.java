import java.util.*;

class Solution {
    
    static int distance;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0 ,-1};
    static String[] ch = {"d", "l", "r", "u"};
    static StringBuilder stb;
    static int sN, sM, sX, sY, sR, sC, sK;
    static boolean searchOver = false;
    static String answer;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "";
        distance = 0;
        stb = new StringBuilder();
        sN = n;
        sM = m;
        sX = x;
        sY = y;
        sR = r;
        sC = c;
        sK = k;
        
        if((Math.abs(sR - sX) + Math.abs(sC - sY)) > sK || 
           ((Math.abs(sR - sX) + Math.abs(sC - sY)) & 1) != (sK & 1)){
            answer = "impossible";
        }else {
            dfs(x, y);
        }
        
        return answer;
    }
    
    static private void dfs(int myY, int myX){
        if(searchOver) return;
        
        if(myY == sR && myX == sC && distance == sK) {
            answer = stb.toString();
            searchOver = true;
            return;
        }
        
        if(distance > sK) return;
        
        for(int d=0; d < 4; d++) {
            int newY = myY + dy[d];
            int newX = myX + dx[d];
            if(newY < 1 || newX < 1 || newY > sN || newX > sM) continue;
            if(Math.abs(sR - newY) + Math.abs(sC - newX) + distance + 1 > sK) continue;
            stb.append(ch[d]);
            distance++;
            dfs(newY, newX);
            distance--;
            stb.deleteCharAt(stb.length() - 1);
        }
    }
}