package 이가빠진이진트리_26260;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] values;
	static int n;
	static ArrayDeque<Integer> stack;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		StringBuilder stb = new StringBuilder();
		stack = new ArrayDeque<>();

		values = new int[n + 1];
		int erasedIdx = -1;

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 1; i <= n; i++) {
			int value = Integer.parseInt(st.nextToken());
			values[i] = value;
			if (value == -1)
				erasedIdx = i;
		}

		values[erasedIdx] = Integer.parseInt(br.readLine().trim());

		Arrays.sort(values);

		findMiddle(1, n);

		while (!stack.isEmpty())
			stb.append(stack.removeLast()).append(' ');

		System.out.println(stb);

	}

	public static void findMiddle(int start, int end) {

		if (start == end) {
			stack.addLast(values[start]);
			return;
		}

		int middle = (start + end) / 2;
		stack.addLast(values[middle]);
		findMiddle(middle + 1, end);
		findMiddle(start, middle - 1);
	}
}
