import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n, s, answer;
    static int[] arr;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
        permutation(0);
        System.out.println(answer);
    }

    private static void permutation(int idx) {
        if (idx >= n) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += arr[i];
                    count++;
                }
            }
            if (sum == s && count > 0) answer++;
            return;
        }
        visited[idx] = true;
        permutation(idx + 1);
        visited[idx] = false;
        permutation(idx + 1);
    }
}
