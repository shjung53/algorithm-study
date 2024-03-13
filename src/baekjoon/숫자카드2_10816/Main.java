package baekjoon.숫자카드2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n, m;

    static int[] sangeun;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        st = new StringTokenizer(br.readLine().trim());

        sangeun = new int[n];

        for (int i = 0; i < n; i++) {
            sangeun[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sangeun);

        m = Integer.parseInt(br.readLine().trim());

        StringBuilder stb = new StringBuilder();

        st = new StringTokenizer(br.readLine().trim());

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());

            int upper = getUpper(number);
            int lower = getLower(number);

            stb.append(upper - lower - 1).append(' ');
        }

        System.out.println(stb);
    }

    static int getUpper(int number) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (sangeun[mid] > number) {
                right = mid - 1;
            }
            if (sangeun[mid] <= number) {
                left = mid + 1;
            }
        }

        return left;
    }

    static int getLower(int number) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (sangeun[mid] >= number) {
                right = mid - 1;
            }
            if (sangeun[mid] < number) {
                left = mid + 1;
            }
        }

        return right;
    }
}
