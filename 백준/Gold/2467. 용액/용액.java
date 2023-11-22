import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[] arr;
	static int left;
	static int right;
	static int answer1;
	static int answer2;
	static int close;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());

		arr = new int[n];
		left = 0;
		right = n - 1;
		close = Integer.MAX_VALUE;
		answer1 = 0;
		answer2 = 0;

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (left < right) {
			if (left < 0 || right < 0 || left >= n || right >= n)
				break;
			int sum = arr[left] + arr[right];

			if (Math.abs(sum) < close) {
				close = Math.abs(sum);
				answer1 = arr[left];
				answer2 = arr[right];

				if (close == 0)
					break;
			}

			if (sum > 0) {
				right--;
				continue;
			}

			if (sum < 0) {
				left++;
				continue;
			}
		}

		StringBuilder stb = new StringBuilder();
		stb.append(answer1).append(' ').append(answer2);
		System.out.println(stb);
	}
}
