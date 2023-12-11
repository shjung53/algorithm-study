package 치킨배달;

import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = { 1, 1, 1, 0, -1, -1, -1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int n;
	static int m;
	static ArrayList<Chicken> chickens;
	static ArrayList<House> houses;
	static boolean[] maintain;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		chickens = new ArrayList<Chicken>();
		houses = new ArrayList<House>();
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1)
					houses.add(new House(i, j));
				if (num == 2)
					chickens.add(new Chicken(i, j));
			}
		}

		maintain = new boolean[chickens.size()];

		chooseChicken(0, 0);
		System.out.println(answer);

	}

	private static void chooseChicken(int idx, int count) {

		if (count == m) {
			int distance = 0;
			for (House house : houses) {
				// 집에서 가장 가까운 치킨집찾기
				int minDistance = Integer.MAX_VALUE;
				for (int i = 0; i < maintain.length; i++) {
					if (!maintain[i])
						continue; // 닫았으면 패스
					int cal = Math.abs(chickens.get(i).y - house.y) + Math.abs(chickens.get(i).x - house.x);
					minDistance = Math.min(minDistance, cal);
				}
				distance += minDistance; // 최소거리 더하기
			}

			answer = Math.min(answer, distance);
			return;
		}

		if (idx >= chickens.size())
			return;

		maintain[idx] = true;
		chooseChicken(idx + 1, count + 1);
		maintain[idx] = false;
		chooseChicken(idx + 1, count);
	}
}

class Chicken {
	int y, x;

	public Chicken(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class House {
	int y, x;

	public House(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
