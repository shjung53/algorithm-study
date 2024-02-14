package baekjoon.약속_1183;

import java.util.*;
import java.io.*;

public class Main {
    static int n, count;
    static BufferedReader br;
    static StringTokenizer st;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        count = 0;

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = a - b;
        }

        Arrays.sort(arr);

        if (n % 2 == 1) {
            count = 1;
        } else {
            count = Math.abs(arr[(n / 2) - 1] - arr[n / 2]) + 1;
        }

        System.out.println(count);

    }
}
