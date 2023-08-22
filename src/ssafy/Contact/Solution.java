package Contact;

import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int[][] board = new int[101][101];
 
            st = new StringTokenizer(br.readLine());
 
            for (int i = 0; i < n / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                board[from][to]++;
            }
 
            Queue<Integer> queue = new ArrayDeque<>();
 
            int answer = 0;
            int[] visit = new int[101];
            queue.offer(start);
            visit[start] = 1;
 
            while (!queue.isEmpty()) {
                int max = 0;
                int queueSize = queue.size();
                for (int i = 0; i < queueSize; i++) {
                    int from = queue.poll();
                    if (from > max)
                        max = from;
 
                    for (int j = 1; j < 101; j++) {
                        if (board[from][j] > 0 && visit[j] < 1) {
                            queue.offer(j);
                            visit[j] = 1;
                        }
                    }
                }
                answer = max;
            }
            stb.append("#" + tc + " " + answer + "\n");
        }
        System.out.println(stb.toString());
    }
}
