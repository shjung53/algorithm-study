package baekjoon.기타줄_1049;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m, answer, minPackPrice, minOnePrice, left;
    static BufferedReader br;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        left = n;
        minOnePrice = Integer.MAX_VALUE;
        minPackPrice = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int packPrice = Integer.parseInt(st.nextToken());
            int onePrice = Integer.parseInt(st.nextToken());
            if (packPrice < minPackPrice) minPackPrice = packPrice;
            if (onePrice < minOnePrice) minOnePrice = onePrice;
        }

        if (n > 6) {
            answer += Math.min(minPackPrice * (n / 6), minOnePrice * (n / 6) * 6);
            left %= 6;
        }

        answer += Math.min(minOnePrice * left, minPackPrice);

        System.out.println(answer);
    }
}
