package n과m8;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int m;
    static int[] nums;
    static int[] answer;
    static StringBuilder stb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stb = new StringBuilder();

        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        answer = new int[m];
        permutation(0, 0);

        System.out.println(stb);

    }

    public static void permutation(int idx, int num) {

        if (idx >= m) {
            for (int i = 0; i < m; i++) {
                stb.append(answer[i]).append(' ');
            }
            stb.append('\n');
            return;
        }

        for (int i = num; i < n; i++) {
            answer[idx] = nums[i];
            permutation(idx + 1, i);
        }

    }
}

