package 미생물격리;

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;

	static int[] dirY = { 0, -1, 1, 0, 0 };
	static int[] dirX = { 0, 0, 0, -1, 1 };

	static int size;
	static int count;
	static int limitHour;
	static Microbe[][] cells;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());

			size = Integer.parseInt(st.nextToken());
			limitHour = Integer.parseInt(st.nextToken());
			count = Integer.parseInt(st.nextToken());

			int hour = 0;
			int answer = 0;

			PriorityQueue<Microbe> queue = new PriorityQueue<>(1, new Comparator<Microbe>() {

				@Override
				public int compare(Microbe o1, Microbe o2) {
					// TODO Auto-generated method stub
					return o2.amount - o1.amount;
				}
			});

			for (int microbeIdx = 0; microbeIdx < count; microbeIdx++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int amount = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				queue.offer(new Microbe(y, x, amount, dir));
			}

			while (hour < limitHour) {
				// 맵 초기화
				cells = new Microbe[size][size];

				int queueSize = queue.size();

				for (int i = 0; i < queueSize; i++) {
					Microbe nowMicrobe = queue.poll();
					int nowY = nowMicrobe.y;
					int nowX = nowMicrobe.x;
					int nowAmount = nowMicrobe.amount;
					int nowDir = nowMicrobe.dir;

					int newY;
					int newX;
					int newAmount = nowAmount;
					int newDir = nowDir;

					// 가장자리에 위치해 있으면 방향을 반대로 전환
					if (nowY == 0 || nowX == 0 || nowY == size - 1 || nowX == size - 1) {
						switch (nowDir) {
						case 1:
							newDir = 2;
							break;
						case 2:
							newDir = 1;
							break;
						case 3:
							newDir = 4;
							break;
						case 4:
							newDir = 3;
							break;
						}
					}

					// newDir은 세팅된 상태, 이동하면 됨
					newY = nowY + dirY[newDir];
					newX = nowX + dirX[newDir];

					// 이동한 군집이 가장자리에 위치하면 미생물이 절반으로 줄어든다
					if (newY == 0 || newX == 0 || newY == size - 1 || newX == size - 1) {
						newAmount = nowAmount / 2;
					}

					if (cells[newY][newX] == null) {
						// 이동한 위치에 군집이 없으면 그냥 넣는다.
						cells[newY][newX] = new Microbe(newY, newX, newAmount, newDir);
					} else {
						// 이동한 위치에 존재하는 군집
						Microbe other = cells[newY][newX];

						// 군집을 합치고 더 큰 군집의 이동방향으로 변경
						cells[newY][newX] = new Microbe(newY, newX, newAmount + other.amount, other.dir);
					}
				}

				// 현재 맵 위의 군집들 다시 큐에 넣기
				for (int rowIdx = 0; rowIdx < size; rowIdx++) {
					for (int colIdx = 0; colIdx < size; colIdx++) {
						if (cells[rowIdx][colIdx] != null)
							queue.offer(cells[rowIdx][colIdx]);
					}
				}

				// 한번 다 돌면 시간++
				hour++;

			}

			for (int rowIdx = 0; rowIdx < size; rowIdx++) {
				for (int colIdx = 0; colIdx < size; colIdx++) {
					if (cells[rowIdx][colIdx] != null)
						answer += cells[rowIdx][colIdx].amount;
				}
			}

			stb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		System.out.println(stb.toString());
	}
}

class Microbe {
	int y;
	int x;
	int amount;
	int dir;

	public Microbe(int y, int x, int amount, int dir) {
		super();
		this.y = y;
		this.x = x;
		this.amount = amount;
		this.dir = dir;
	}

}