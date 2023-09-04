package 랜선자르기_1654;

import java.util.*;
import java.io.*;

public class Main {
	static int k;
	static int n;
	static int[] lengths;
	static long standard;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		lengths = new int[k];
		for (int i = 0; i < k; i++) {
			lengths[i] = Integer.parseInt(br.readLine());
		}

		long sum = 0;
		for (int i = 0; i < k; i++) {
			sum += lengths[i];
		}
		
//		평균으로 나누어 떨어지면 가장 최댓값이 됨
		standard = sum / n;
		int count = 0;

//		안되는 경우에는 나머지 때문에 작아질 수 밖에 없음
		while (count < n) {
			count = 0;
			int next = 0;
			long maxRest = 0;

			for (int i = 0; i < k; i++) {
//				나머지가 가장 큰 전선을 기억해둠
				count += lengths[i] / standard;
				long rest = lengths[i] % standard;
				if (rest > maxRest) {
					maxRest = rest;
					next = i;
				}
			}
			
//			성공하면 탈출
			if(count >= n) break;

//			실패시 나머지가 가장 큰 전선을 한 개 더 늘릴 수 있는  가장 큰 기준길이를 구한다.
			long nextDivide = (lengths[next] / standard) + 1;
			standard = lengths[next] / nextDivide;
		}

		System.out.println(standard);
	}
}
