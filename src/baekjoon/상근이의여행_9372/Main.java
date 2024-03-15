package baekjoon.상근이의여행_9372;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    static int n, m, tc;

    static public void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine().trim());
        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine().trim());
            }

            stb.append(n - 1).append('\n');
        }
        System.out.println(stb);
    }
}
