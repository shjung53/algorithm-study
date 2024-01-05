package 랜선자르기_1654;

import java.util.*;
import java.io.*;

public class Main {
	static int k;
	static int n;
	static int[] lengths;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		lengths = new int[k];
		for (int i = 0; i < k; i++) {
			lengths[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(lengths);
		
		long start = 1;
//		n >= 1 이므로 가장 긴 랜선이 최대 길이
		long end = lengths[k-1];

//		이분탐색으로 조건이 성립하는 범위 내 가장 큰 길이를 구해야 한다.
		while (end > start) {
			long mid = (start + end) / 2;
			long count = 0;

			for (int i = 0; i < k; i++) {
				count += lengths[i] / mid;
			}

//			end를 최댓값으로 뽑아내기 때문에  count가 n 이상이면 start를 mid + 1
//			답이 현재 mid인 경우 end가 작아지다가 현재 mid가 될때 while을 탈출함
			if(count >= n) start = mid + 1;
			if(count < n) end = mid - 1;
		}

		System.out.println(end);
	}
}
