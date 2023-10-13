package 야구공;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;

	static int maxInning;
	static Player[] players;
	static boolean[] selected; // 선수가 선택되었는지 안되었는지
	static int[] order; // 몇번째 선수인지
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		maxInning = Integer.parseInt(br.readLine().trim());

		players = new Player[9];
		for (int i = 0; i < 9; i++) {
			players[i] = new Player(maxInning); // 선수들 초기화
		}

		for (int inning = 0; inning < maxInning; inning++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 9; j++) {
				players[j].performance[inning] = Integer.parseInt(st.nextToken());
			}
		}

		// 모든 선수들 순서 먼저 정하기 순열
		order = new int[9];
		selected = new boolean[9];
		answer = Integer.MIN_VALUE;

		selected[0] = true;
		order[3] = 0; // 1번 선수가 4번타자
		setOrder(0);

		System.out.println(answer);

	}

	private static void setOrder(int orderIdx) {

		if (orderIdx == 9) {
			// 순서 선정 완료 이제 게임 시작하자
			gameStart();
			return;
		}

		if (orderIdx == 3) {
			setOrder(orderIdx + 1);
		} else {
			for (int playerIdx = 1; playerIdx < 9; playerIdx++) {
				if (selected[playerIdx])
					continue;
				selected[playerIdx] = true; // 선택 표시
				order[orderIdx] = playerIdx; // 순서에 선수 번호 넣기
				setOrder(orderIdx + 1); // 다음 순서 선택하러 간다
				selected[playerIdx] = false; // 다음 선택을 위해 체크 해제
			}
		}
	}

	private static void gameStart() {
		int point = 0; // 점수가 얼마나 나는지
		int nowIdx = 0; // 현재 타자 순서

		for (int inning = 0; inning < maxInning; inning++) {
			int outCount = 0;
			boolean[] base = new boolean[3]; // 베이스

			// 아웃 카운트 3개면 다음 이닝으로 끝
			while (outCount < 3) {
				Player now = players[order[nowIdx]];

				// 선수의 현재 이닝 퍼포먼스 반영
				switch (now.performance[inning]) {
				case 1:
					if (base[2] == true) {
						point++;
						base[2] = false;
					}

					if (base[1] == true) {
						base[2] = true;
						base[1] = false;
					}

					if (base[0] == true) {
						base[1] = true;
						base[0] = false;
					}

					base[0] = true;

					break;
				case 2:
					if (base[2] == true) {
						point++;
						base[2] = false;
					}

					if (base[1] == true) {
						point++;
						base[1] = false;
					}

					if (base[0] == true) {
						base[2] = true;
						base[0] = false;
					}

					base[1] = true;
					break;
				case 3:
					if (base[2] == true) {
						point++;
						base[2] = false;
					}

					if (base[1] == true) {
						point++;
						base[1] = false;
					}

					if (base[0] == true) {
						point++;
						base[0] = false;
					}

					base[2] = true;
					break;
				case 4:
					if (base[2] == true) {
						point++;
						base[2] = false;
					}

					if (base[1] == true) {
						point++;
						base[1] = false;
					}

					if (base[0] == true) {
						point++;
						base[0] = false;
					}
					point++;
					break;
				case 0:
					outCount += 1;
					break;

				}
				nowIdx++;
				nowIdx %= 9; // 치고 나서 다음 타자 순서
			}
		}
		// 모든 이닝 종료하고 점수 확인
		if (point > answer)
			answer = point;
	}
}

class Player {
	int[] performance;

	public Player(int maxInning) {
		this.performance = new int[maxInning];
	}
}
