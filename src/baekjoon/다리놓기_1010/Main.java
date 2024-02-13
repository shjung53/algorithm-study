package baekjoon.다리놓기_1010;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine().trim());

        for(int i=0; i<test; i++) {
            st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(m - n < n) n = m - n;

            int count = n;
            long answer = 1;
            while(count > 0) {
                answer *= (m - count + 1);
                count--;
            }

            for(int divide = n; divide > 0; divide--) {
                answer /= divide;
            }

            System.out.println(answer);
        }

    }
}
