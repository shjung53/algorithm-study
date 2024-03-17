package baekjoon.듣보잡_1764;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n, m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> neverHeard = new HashSet<>();
        HashSet<String> neverSeen = new HashSet<>();

        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            neverHeard.add(br.readLine().trim());
        }
        for (int i = 0; i < m; i++) {
            neverSeen.add(br.readLine().trim());
        }

        ArrayList<String> neverHeardAndSeen = new ArrayList();

        for (String name : neverHeard) {
            if (neverSeen.contains(name)) neverHeardAndSeen.add(name);
        }

        Collections.sort(neverHeardAndSeen);

        StringBuilder stb = new StringBuilder();
        stb.append(neverHeardAndSeen.size()).append('\n');
        for (String name : neverHeardAndSeen) {
            stb.append(name).append('\n');
        }

        System.out.println(stb);
    }
}
