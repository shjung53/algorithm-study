package ssafy.pre_edu;

import java.util.Scanner;

/*
N x N 행렬이 주어질 때,
시계 방향으로 90도, 180도, 270도 회전한 모양을 출력하라.

[제약 사항]
N은 3 이상 7 이하이다.

[입력]
가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
각 테스트 케이스의 첫 번째 줄에 N이 주어지고,
다음 N 줄에는 N x N 행렬이 주어진다.

[출력]
출력의 첫 줄은 '#t'로 시작하고,
다음 N줄에 걸쳐서 90도, 180도, 270도 회전한 모양을 출력한다.
입력과는 달리 출력에서는 회전한 모양 사이에만 공백이 존재함에 유의하라.
(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
 */

public class LevelMiddle_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LevelMiddle_3 sol = new LevelMiddle_3();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            int[][] arr90 = sol.rotate90Arr(arr, n);
            int[][] arr180 = sol.rotate90Arr(arr90, n);
            int[][] arr270 = sol.rotate90Arr(arr180, n);

            System.out.println("#" + i);
            for (int p = 0; p < n; p++) {
                for (int r = 0; r < n; r++) {
                    System.out.print(arr90[p][r]);
                }
                System.out.print(" ");
                for (int r = 0; r < n; r++) {
                    System.out.print(arr180[p][r]);
                }
                System.out.print(" ");
                for (int r = 0; r < n; r++) {
                    System.out.print(arr270[p][r]);
                }
                System.out.println();
            }

        }
    }

    private int[][] rotate90Arr(int[][] arr, int n) {
        int[][] arr90 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr90[i][j] = arr[n - 1 - j][i];
            }
        }
        return arr90;
    }
}
