package ssafy.베르트랑공준_4948;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static boolean[] arr; // true면 소수가 아니다.

    static int n;
    static int max = 123456 * 2 + 1;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        arr = new boolean[max]; // 2n의 최댓값을 가질 수 있는 배열의 크기

        for (int i = 2; i < max; i++) {
            if (arr[i]) continue;
            if (checkPrime(i)) {
                eraseMulti(i);
            }
        }

        while (true) {
            n = Integer.parseInt(br.readLine().trim());
            if (n == 0) {
                break;
            }
            int count = 0;

            for (int i = n + 1; i <= 2 * n; i++) {
                if (!arr[i]) count++;
            }

            System.out.println(count);
        }
    }

    private static boolean checkPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static void eraseMulti(int n) {
        int multi = n + n;
        while (multi < max) {
            arr[multi] = true;
            multi += n;
        }
    }
}
