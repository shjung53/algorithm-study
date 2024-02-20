package baekjoon.ATM_11399;

import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] time;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        time = new int[n];

        st = new StringTokenizer(br.readLine().trim());

        for(int i=0; i<n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int wait = 0;

        Arrays.sort(time);

        for(int i=0; i<n; i++) {
            sum += time[i] + wait;
            wait += time[i];
        }

        System.out.println(sum);

    }
}
