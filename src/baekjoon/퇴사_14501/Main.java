package 퇴사_14501;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int n, answer;
	static Consulting[] consultings;
	static int[] profitLog;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		consultings = new Consulting[n];
		profitLog = new int[n];
		answer = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			consultings[i] = new Consulting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		PriorityQueue<Case> queue = new PriorityQueue<Case>(1, new Comparator<Case>() {

			@Override
			public int compare(Case o1, Case o2) {
				// TODO Auto-generated method stub
				return o2.price - o1.price;
			}
		});

		queue.offer(new Case(0, 0));

		while (!queue.isEmpty()) {
			Case now = queue.poll();

			if (now.number >= n) {
				if (now.price > answer)
					answer = now.price;
				continue;
			}
			
			int nowPrice = consultings[now.number].price;
			int nowTime = consultings[now.number].time;

			// 퇴사일 전에 상담이 끝나야 한다.
			if (now.number + nowTime - 1 < n) {
				// 상담을 마치고 나서의 금액 기록이 다른 경우의 수보다 작으면 진행하지 않는다.
				if (now.price + nowPrice > profitLog[now.number + nowTime - 1]) {
					profitLog[now.number + nowTime - 1] = now.price + nowPrice;
					queue.offer(new Case(now.number + nowTime, now.price + nowPrice));
				}
			}

			queue.offer(new Case(now.number + 1, now.price));
		}
		
		System.out.println(answer);

	}
}

class Case {
	int number, price;

	public Case(int number, int price) {
		this.number = number;
		this.price = price;
	}
}

class Consulting {
	int time, price;

	public Consulting(int time, int price) {
		this.time = time;
		this.price = price;
	}
}
