package baekjoon.숫자카드_10815;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n, m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        n = Integer.parseInt(br.readLine().trim());
        HashSet<Integer> pool = new HashSet<>();
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            pool.add(Integer.parseInt(st.nextToken()));
        }
        m = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            if (pool.contains(Integer.parseInt(st.nextToken()))) {
                stb.append('1').append(' ');
            } else {
                stb.append('0').append(' ');
            }
        }
        System.out.println(stb);
    }
}
