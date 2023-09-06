package 개똥벌레_3020;

import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int h;
	static int[] down;
	static int[] up;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		down = new int[n / 2];
		up = new int[n / 2];
		for (int i = 0; i < n / 2; i++) {
			down[i] = Integer.parseInt(br.readLine());
			up[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(down);
		Arrays.sort(up);

		int min = n;
		int minCount = 0;

		for (int i = 1; i <= h; i++) {
			int count = countWall(i, down) + countWall(h - i + 1, up);

			if (min == count)
				minCount++;

			if (count < min) {
				min = count;
				minCount = 1;
			}
		}

		System.out.println("" + min + " " + minCount);

	}

	private static int countWall(int height, int[] arr) {
		int start = 0;
		int end = n / 2  - 1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] >= height) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		return n / 2 - start;

	}
}
