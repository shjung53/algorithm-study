package baekjoon.패션왕신해빈_9375;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int m = Integer.parseInt(br.readLine().trim());
            for (int j = 0; j < m; j++) {
                String type = br.readLine().trim().split(" ")[1];
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            int answer = 1;

            for (String key : map.keySet()) {
                answer *= map.get(key) + 1;
            }

            System.out.println(answer - 1);
        }

    }
}
