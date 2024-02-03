import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, k, answer;
    static int[] arr;

    static int[] order;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        order = new int[n];
        visited = new boolean[n];
        answer = 0;
        permutation(0, 500);
        System.out.println(answer);
    }

    private static void permutation(int idx, int weight){
        if(idx >= n) {
            answer++;
            return;
        }
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            if(weight - k + arr[i] >= 500) permutation(idx + 1, weight - k + arr[i]);
            visited[i] = false;
        }
    }
}
