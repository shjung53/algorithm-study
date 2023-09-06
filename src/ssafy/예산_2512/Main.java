package 예산_2512;

import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] request;
	static int m;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		request = new int[n];
		for (int i = 0; i < n; i++) {
			request[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());

		Arrays.sort(request);

		int start = 1;
		int end = request[n - 1];

		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if(request[i] >= mid) sum += mid;
				if(request[i] < mid) sum += request[i];
			}
			
			if(sum > m) end = mid - 1;
			if(sum <= m) start = mid + 1;
		}
		
		System.out.println(end);

	}
}
