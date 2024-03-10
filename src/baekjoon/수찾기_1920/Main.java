package baekjoon.수찾기_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n;
    static int m;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        arr = new int[n];

        st = new StringTokenizer(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine().trim());

        st = new StringTokenizer(br.readLine());

        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number < arr[0] || number > arr[n - 1]) {
                stb.append(0).append('\n');
                continue;
            }

            int left = 0;
            int right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (number == arr[mid]) {
                    left = mid;
                    break;
                }
                if (number > arr[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (arr[left] == number) {
                stb.append(1).append('\n');
            } else {
                stb.append(0).append('\n');
            }

        }

        System.out.println(stb);

    }
}
