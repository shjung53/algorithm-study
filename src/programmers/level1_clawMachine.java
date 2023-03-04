package programmers;

import java.util.Stack;

public class level1_clawMachine {
    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            int size = board.length;
            Stack<Integer> basket = new Stack<Integer>();

            for (int m : moves) {
                int pos = m - 1;
                if (board[size - 1][pos] == 0) {
                    continue;
                }

                for (int i = 0; i < size; i++) {
                    if (board[i][pos] > 0) {
                        if (basket.size() == 0) {
                            basket.push(board[i][pos]);
                            board[i][pos] = 0;
                            break;
                        }

                        if (board[i][pos] == basket.peek()) {
                            basket.pop();
                            board[i][pos] = 0;
                            answer += 2;
                            break;
                        } else {
                            basket.push(board[i][pos]);
                            board[i][pos] = 0;
                            break;
                        }
                    }
                }
            }
            return answer;
        }
    }

}
