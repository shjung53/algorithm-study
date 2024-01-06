package 주식_11501;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int[] stockPrice; // 1부터 10,000 까지 값을 갖는 주가의 날이 얼마나 있는지
	static int[] priceToday; // 해당 날짜의 주가
	static int days; // 며칠동안 주식을 하는가
	static int maxPrice; // 앞으로 남은 주가중 가장 비싼 가격
	static int stock; // 주식의 개수
	static long profit; // 수익
	static long buy_money; // 주식 산 금액

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= testCase; tc++) {
			days = Integer.parseInt(br.readLine().trim());
			stockPrice = new int[10001];
			priceToday = new int[days];
			maxPrice = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < days; i++) {
				int price = Integer.parseInt(st.nextToken());
				priceToday[i] = price;
				stockPrice[price]++; // 주가 날짜 추가
				if (price > maxPrice)
					maxPrice = price; // maxPrice 설정
			}

			stock = 0;
			buy_money = 0;
			profit = 0;

			for (int i = 0; i < days; i++) {
				int price = priceToday[i]; // 오늘의 주가

				// 주식을 사거나
				if (price < maxPrice) {
					stock++;
					buy_money += price;
					stockPrice[price]--;
					continue;
				}
				// 주식을 팔거나
				if (price == maxPrice) {
					profit += stock * price - buy_money;
					stock = 0;
					buy_money = 0;
					stockPrice[price]--;
					// maxPrice 날짜가 더 이상 없으면 업데이트
					if (stockPrice[price] == 0) {
						updateMaxPrice();
					}
				}
				// 아무것도 안하기
			}

			System.out.println(profit);

		}
	}

	private static void updateMaxPrice() {
		for (int i = 10000; i >= 0; i--) {
			if (stockPrice[i] > 0) {
				maxPrice = i;
				break;
			}
		}
	}
}
