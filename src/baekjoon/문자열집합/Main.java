package baekjoon.문자열집합;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;

    static StringTokenizer st;

    static int n, m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashSet<String> s = new HashSet<>();

        int count = 0;

        for (int i = 0; i < n; i++) {
            s.add(br.readLine().trim());
        }

        for (int i = 0; i < m; i++) {
            if (s.contains(br.readLine().trim())) count++;
        }

        System.out.println(count);
    }
}
