import java.util.*;

class Solution {
    static Node[] nodes = new Node[1000001];
    static HashSet<Integer> point = new HashSet<Integer>();
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        for(int[] link : edges) {
            int from = link[0];
            int to = link[1];
            if(nodes[from] == null) {
                nodes[from] = new Node();
                point.add(from);
            }
            if(nodes[to] == null) {
                nodes[to] = new Node();
                point.add(to);
            }
            nodes[to].linkedFrom.add(from);
            nodes[from].linkTo.add(to);
        }
                
        for(int number: point) {
            Node node = nodes[number];
            if(node.linkTo.size() > 1 && node.linkedFrom.size() == 0) {
                answer[0] = number;
                continue;
            }
            
            if(node.linkTo.size() == 0) answer[2]++;
            if(node.linkTo.size() > 1 && node.linkedFrom.size() >1) answer[3]++;
        }
        
        answer[1] = nodes[answer[0]].linkTo.size() - answer[2] - answer[3];
        
        return answer;
    }
}

class Node{
    HashSet<Integer> linkTo = new HashSet<>();
    HashSet<Integer> linkedFrom = new HashSet<>();
}