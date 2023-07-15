package ssafy.pre_edu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
스도쿠는 숫자퍼즐로, 가로 9칸 세로 9칸으로 이루어져 있는 표에 1 부터 9 까지의 숫자를 채워넣는 퍼즐이다.
같은 줄에 1 에서 9 까지의 숫자를 한번씩만 넣고, 3 x 3 크기의 작은 격자 또한, 1 에서 9 까지의 숫자가 겹치지 않아야 한다.
입력으로 9 X 9 크기의 스도쿠 퍼즐의 숫자들이 주어졌을 때, 위와 같이 겹치는 숫자가 없을 경우, 1을 정답으로 출력하고 그렇지 않을 경우 0 을 출력한다.

[제약 사항]
1. 퍼즐은 모두 숫자로 채워진 상태로 주어진다.
2. 입력으로 주어지는 퍼즐의 모든 숫자는 1 이상 9 이하의 정수이다.

[입력]
입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.
다음 줄부터 각 테스트 케이스가 주어진다.
테스트 케이스는 9 x 9 크기의 퍼즐의 데이터이다.

[출력]
테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
 */
public class LevelMiddle_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LevelMiddle_2 sol = new LevelMiddle_2();
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int answer = 1;
            int[][] board = new int[9][9];
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    board[j][k] = sc.nextInt();
                }
            }
            if (!sol.checkColumn(board)) answer = 0;
            if (answer == 1 && !sol.checkRow(board)) answer = 0;
            if (answer == 1 && !sol.checkSquare(board))answer = 0;

            System.out.println("#" + i + " " + answer);
        }
    }

    private boolean checkColumn(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> duplicationCheckSet = new HashSet<>();
            for (int[] ints : arr) {
                if (duplicationCheckSet.contains(ints[i])) {
                    return false;
                } else {
                    duplicationCheckSet.add(ints[i]);
                }
            }
        }
        return true;
    }

    private boolean checkRow(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> duplicationCheckSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (duplicationCheckSet.contains(arr[i][j])) {
                    return false;
                } else {
                    duplicationCheckSet.add(arr[i][j]);
                }
            }
        }
        return true;
    }

    private boolean checkSquare(int[][] arr) {
        int[][] xIndex = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        int[][] yIndex = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

        for (int[] xList : xIndex) {
            for (int[] yList : yIndex) {
                Set<Integer> duplicationCheckSet = new HashSet<>();
                for (int x : xList) {
                    for (int y : yList) {
                        if (duplicationCheckSet.contains(arr[y][x])) {
                            return false;
                        } else {
                            duplicationCheckSet.add(arr[y][x]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
