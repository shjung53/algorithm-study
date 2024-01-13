package baekjoon.ioioi_5525;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int n, s;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        s = Integer.parseInt(br.readLine().trim());
        int answer = 0;

        String str = br.readLine().trim();
        char beforeChar = 'O';
        int count = 0;

        for (int idx = 0; idx < s; idx++) {
            if (beforeChar == str.charAt(idx)) {
                if ((count - 1) / 2 >= n) answer += 1 + ((count - 1) / 2) - n;
                count = 0;
                if(beforeChar == 'I') count = 1;
            } else {
                count++;
            }
            beforeChar = str.charAt(idx);
        }

        if ((count - 1) / 2 >= n) answer += 1 + ((count - 1) / 2) - n;

        System.out.println(answer);
    }
}
