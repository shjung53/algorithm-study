package ssafy.pre_edu;

import java.util.Scanner;

/*
N x N 배열 안의 숫자는 해당 영역에 존재하는 파리의 개체 수를 의미한다.

아래는 N=5 의 예이다.

파리 킬러 스프레이를 한 번만 뿌려 최대한 많은 파리를 잡으려고 한다. 스프레이의 노즐이 + 형태로 되어있어, 스프레이는 + 혹은 x 형태로 분사된다. 스프레이를 M의 세기로 분사하면 노즐의 중심이 향한 칸부터 각 방향으로 M칸의 파리를 잡을 수 있다.
다음은 M=3 세기로 스프레이르 분사한 경우 파리가 퇴치되는 칸의 예로, +또는 x 중 하나로 분사된다. 뿌려진 일부가 영역을 벗어나도 상관없다.

한 번에 잡을 수 있는 최대 파리수를 출력하라.

[제약 사항]

1. N 은 5 이상 15 이하이다.
2. M은 2 이상 N 이하이다.
3. 각 영역의 파리 갯수는 30 이하 이다.

[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
각 테스트 케이스의 첫 번째 줄에 N 과 M 이 주어지고,
다음 N 줄에 걸쳐 N x N 배열이 주어진다.
 */
public class LevelMiddle_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LevelMiddle_1 sol = new LevelMiddle_1();
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            System.out.println("#" + i + " " + sol.getMaxFlies(arr, m));
        }
    }


    int getMaxFlies(int[][] arr, int m) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = xNozzle(arr, m, i, j);
                int cross = crossNozzle(arr, m, i, j);
                if (x > max) max = x;
                if (cross > max) max = cross;
            }
        }
        return max;
    }

    private int xNozzle(int[][] arr, int m, int startY, int startX) {
        int n = arr.length;
        int sum = 0;
        for (int i = 1; i < m; i++) {
            if (startY + i < n && startX + i < n) {
                sum += arr[startY + i][startX + i];
            }
            if (startY + i < n && startX - i >= 0) {
                sum += arr[startY + i][startX - i];
            }
            if (startY - i >= 0 && startX + i < n) {
                sum += arr[startY - i][startX + i];
            }
            if (startY - i >= 0 && startX - i >= 0) {
                sum += arr[startY - i][startX - i];
            }
        }
        sum += arr[startY][startX];
        return sum;
    }

    private int crossNozzle(int[][] arr, int m, int startY, int startX) {
        int n = arr.length;
        int sum = 0;
        for (int i = 1; i < m; i++) {
            if (startY + i < n) {
                sum += arr[startY + i][startX];
            }
            if (startY - i >= 0) {
                sum += arr[startY - i][startX];
            }
            if (startX + i < n) {
                sum += arr[startY][startX + i];
            }
            if (startX - i >= 0) {
                sum += arr[startY][startX - i];
            }
        }
        sum += arr[startY][startX];
        return sum;
    }
}

