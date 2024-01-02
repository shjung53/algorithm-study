package 이공사팔_12100;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map;
	static int n, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		answer = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		setOrder(0, new int[5]);
		System.out.println(answer);

	}

	private static void setOrder(int idx, int[] orders) {
		if (idx == 5) {
			play(orders);
			return;
		}

		for (int i = 0; i < 4; i++) {
			orders[idx] = i;
			setOrder(idx + 1, orders);
		}
	}

	private static void play(int[] orders) {
		int[][] temp = new int[n][n];

		for (int i = 0; i < n; i++) {
			temp[i] = map[i].clone();
		}

		for (int direction : orders) {
			switch (direction) {
			case 0: {
				for (int i = 0; i < n; i++) {
					ArrayDeque<Integer> deque = new ArrayDeque<>();
					boolean canCombine = false;
					for (int j = 0; j < n; j++) {
						if (temp[i][j] == 0)
							continue;
						if (canCombine && deque.peekLast() == temp[i][j]) {
							deque.addLast(deque.removeLast() + temp[i][j]);
							canCombine = false;
						} else {
							deque.addLast(temp[i][j]);
							canCombine = true;
						}
					}

					for (int idx = 0; idx < n; idx++) {
						if (!deque.isEmpty()) {
							temp[i][idx] = deque.removeFirst();
						} else {
							temp[i][idx] = 0;
						}
					}
				}
			}
				break;
			case 1: {
				for (int i = 0; i < n; i++) {
					ArrayDeque<Integer> deque = new ArrayDeque<>();
					boolean canCombine = false;
					for (int j = 0; j < n; j++) {
						if (temp[j][i] == 0)
							continue;
						if (canCombine && deque.peekLast() == temp[j][i]) {
							deque.addLast(deque.removeLast() + temp[j][i]);
							canCombine = false;
						} else {
							deque.addLast(temp[j][i]);
							canCombine = true;
						}
					}

					for (int idx = 0; idx < n; idx++) {
						if (!deque.isEmpty()) {
							temp[idx][i] = deque.removeFirst();
						} else {
							temp[idx][i] = 0;
						}
					}
				}
			}
				break;
			case 2: {
				for (int i = n - 1; i >= 0; i--) {
					ArrayDeque<Integer> deque = new ArrayDeque<>();
					boolean canCombine = false;
					for (int j = n - 1; j >= 0; j--) {
						if (temp[i][j] == 0)
							continue;
						if (canCombine && deque.peekLast() == temp[i][j]) {
							deque.addLast(deque.removeLast() + temp[i][j]);
							canCombine = false;
						} else {
							deque.addLast(temp[i][j]);
							canCombine = true;
						}
					}

					for (int idx = n - 1; idx >= 0; idx--) {
						if (!deque.isEmpty()) {
							temp[i][idx] = deque.removeFirst();
						} else {
							temp[i][idx] = 0;
						}
					}
				}
			}
				break;
			case 3: {
				for (int i = n - 1; i >= 0; i--) {
					ArrayDeque<Integer> deque = new ArrayDeque<>();
					boolean canCombine = false;
					for (int j = n - 1; j >= 0; j--) {
						if (temp[j][i] == 0)
							continue;
						if (canCombine && deque.peekLast() == temp[j][i]) {
							deque.addLast(deque.removeLast() + temp[j][i]);
							canCombine = false;
						} else {
							deque.addLast(temp[j][i]);
							canCombine = true;
						}
					}

					for (int idx = n - 1; idx >= 0; idx--) {
						if (!deque.isEmpty()) {
							temp[idx][i] = deque.removeFirst();
						} else {
							temp[idx][i] = 0;
						}
					}
				}
			}
				break;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (temp[i][j] > answer)
					answer = temp[i][j];
			}
		}
	}

}
