package baekjoon.비밀번호찾기_17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            String site = st.nextToken();
            String password = st.nextToken();
            map.put(site, password);
        }

        StringBuilder stb = new StringBuilder();

        for(int i=0; i<m; i++) {
            stb.append(map.get(br.readLine().trim())).append('\n');
        }

        System.out.println(stb);
    }
}
