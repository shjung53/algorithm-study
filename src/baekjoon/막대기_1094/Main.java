package baekjoon.막대기_1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static int x;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine().trim());
        String binary = Integer.toBinaryString(x);

        int answer = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') answer++;
        }

        System.out.println(answer);
    }
}
