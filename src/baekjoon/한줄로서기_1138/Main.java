package baekjoon.한줄로서기_1138;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n;

    static int[] arr;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());

        arr = new int[n];
        answer = new int[n];

        st = new StringTokenizer(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int height = 0; height < n; height++) {
            int left = arr[height];
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (left == count) {
                    if(answer[i] > 0) continue;
                    answer[i] = height + 1;
                    break;
                }
                if (answer[i] == 0) {
                    count++;
                    continue;
                }
                if (answer[i] > 0 && answer[i] - 1 > height) {
                    count++;
                    continue;
                }
            }
        }

        StringBuilder stb = new StringBuilder();

        for (int num : answer) {
            stb.append(num).append(' ');
        }

        System.out.println(stb);

    }
}
