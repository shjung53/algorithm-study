package baekjoon.카드_11652;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Long, Long> map = new HashMap<>();
        long n = Integer.parseInt(br.readLine().trim());
        long answer = 0;
        for (int i = 0; i < n; i++) {
            long number = Long.parseLong(br.readLine().trim());
            map.put(number, map.getOrDefault(number, 0L) + 1);
            if (answer == 0) answer = number;
            if (map.get(number) > map.get(answer)) answer = number;
            if (map.get(number).equals(map.get(answer))) answer = Math.min(number, answer);
        }

        System.out.println(answer);
    }
}
