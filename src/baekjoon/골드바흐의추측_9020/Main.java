package baekjoon.골드바흐의추측_9020;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;

    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine().trim());
            int a = 0;
            int b = 0;
            for (int j = 2; j <= number / 2; j++) {
                int left = number - j;
                if(isPrime(j) && isPrime(left)) {
                    a = j;
                    b = left;
                }
            }
            System.out.println(a + " " + b);
        }

    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
            if (i * i > number) return true;
        }
        return true;
    }
}
