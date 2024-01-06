package 타일01;

import java.io.*;

public class Main {
	static BufferedReader br;
	static Integer[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		arr = new Integer[n + 1];

		// 직접 구해본 결과 피보나치 수열이었다..
		int answer = fibo(n);

		System.out.println(answer);
	}

	private static int fibo(int index) {
		if (index == 1)
			return arr[index] = 1;
		if (index == 2)
			return arr[index] = 2;

		if (arr[index] == null) {
			return arr[index] = (fibo(index - 1) + fibo(index - 2)) % 15746;
		} else {
			return arr[index];
		}
	}
}
