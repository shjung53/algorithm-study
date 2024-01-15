package baekjoon.로또_6603;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int k;
    static int[] s, select;
    static StringBuilder stb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine().trim());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            select = new int[6];
            combi(0, 0);
            stb.append('\n');
        }
        System.out.println(stb);
    }

    private static void combi(int sIdx, int selectIdx) {
        if(selectIdx >= 6) {
            for(int number : select) {
                stb.append(number).append(' ');
            }
            stb.append('\n');
            return;
        }
        if(sIdx >= k) return;

        select[selectIdx] = s[sIdx];
        combi(sIdx+1, selectIdx + 1);
        combi(sIdx + 1, selectIdx);
    }
}
