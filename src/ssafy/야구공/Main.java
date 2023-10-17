package 야구공;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;

	static int maxInning;
	static Player[] players;
	static boolean[] selected; // ������ ���õǾ����� �ȵǾ�����
	static int[] order; // ���° ��������
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		maxInning = Integer.parseInt(br.readLine().trim());

		players = new Player[9];
		for (int i = 0; i < 9; i++) {
			players[i] = new Player(maxInning); // ������ �ʱ�ȭ
		}

		for (int inning = 0; inning < maxInning; inning++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 9; j++) {
				players[j].performance[inning] = Integer.parseInt(st.nextToken());
			}
		}

		// ��� ������ ���� ���� ���ϱ� ����
		order = new int[9];
		selected = new boolean[9];
		answer = Integer.MIN_VALUE;

		selected[0] = true;
		order[3] = 0; // 1�� ������ 4��Ÿ��
		setOrder(0);

		System.out.println(answer);

	}

	private static void setOrder(int orderIdx) {

		if (orderIdx == 9) {
			// ���� ���� �Ϸ� ���� ���� ��������
			gameStart();
			return;
		}

		if (orderIdx == 3) {
			setOrder(orderIdx + 1);
		} else {
			for (int playerIdx = 1; playerIdx < 9; playerIdx++) {
				if (selected[playerIdx])
					continue;
				selected[playerIdx] = true; // ���� ǥ��
				order[orderIdx] = playerIdx; // ������ ���� ��ȣ �ֱ�
				setOrder(orderIdx + 1); // ���� ���� �����Ϸ� ����
				selected[playerIdx] = false; // ���� ������ ���� üũ ����
			}
		}
	}

	private static void gameStart() {
		int point = 0; // ������ �󸶳� ������
		int nowIdx = 0; // ���� Ÿ�� ����

		for (int inning = 0; inning < maxInning; inning++) {
			int outCount = 0;
			boolean[] base = new boolean[3]; // ���̽�

			// �ƿ� ī��Ʈ 3���� ���� �̴����� ��
			while (outCount < 3) {
				Player now = players[order[nowIdx]];

				// ������ ���� �̴� �����ս� �ݿ�
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
				nowIdx %= 9; // ġ�� ���� ���� Ÿ�� ����
			}
		}
		// ��� �̴� �����ϰ� ���� Ȯ��
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
