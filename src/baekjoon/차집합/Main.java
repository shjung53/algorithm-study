package baekjoon.차집합;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        HashSet<Integer> aSet = new HashSet<>();
        HashSet<Integer> bSet = new HashSet<>();

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < a; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < b; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> c = new ArrayList<>();

        for (int e : aSet) {
            if (!bSet.contains(e)) {
                c.add(e);
            }
        }

        StringBuilder stb = new StringBuilder();

        stb.append(c.size());

        Collections.sort(c);

        if (!c.isEmpty()) stb.append('\n');
        for (Integer integer : c) {
            stb.append(integer).append(' ');
        }
        System.out.println(stb);
    }
}
