package baekjoon.게임_1072;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    static long x, y, z;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = (y * 100 / x);

        if(z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 0;
        long right = x;

        while(left <= right) {
            long mid = (left + right) / 2;

            long newZ = (y + mid) * 100 / (x + mid);

            if(newZ > z) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
