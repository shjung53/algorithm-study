package baekjoon.배열복원하기_16967;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    static int[][] matrixB;

    static int[][] matrixA;

    static int h, w, x, y;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        matrixA = new int[h][w];
        matrixB = new int[h + x][w + y];

        for (int i = 0; i < h + x; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < w + y; j++) {
                matrixB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i >= x && j >= y) {
                    matrixA[i][j] = matrixB[i][j] - matrixA[i - x][j - y];
                } else {
                    matrixA[i][j] = matrixB[i][j];
                }
            }
        }

        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                stb.append(matrixA[i][j]).append(' ');
            }
            stb.append('\n');
        }

        System.out.println(stb);
    }
}
