package 계산기3;

import java.util.*;
import java.io.*;

public class Solution {
	static StringBuilder stb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int lineLength = Integer.parseInt(br.readLine());

			String line = br.readLine();

			Deque<Character> ad = new ArrayDeque();

			String str = "";

			for (int i = 0; i < lineLength; i++) {
				char it = line.charAt(i);

				if (Character.isDigit(it)) {
					str += it;
					continue;
				}

				if (it == '(') {
					ad.addLast(it);
					continue;
				}

				if (it == ')') {
					while (!ad.isEmpty() && ad.peekLast() != '(') {
						str += ad.removeLast();
					}
					ad.removeLast();
					continue;
				}

				if (it == '*') {
					if (!ad.isEmpty() && ad.peekLast() != '+' && ad.peekLast() != '(') {
						str += ad.removeLast();
					}
					ad.addLast(it);
					continue;
				}

				if (it == '+') {
					while (!ad.isEmpty() && ad.peekLast() != '(') {
						str += ad.removeLast();
					}
					ad.addLast(it);
				}
			}

			while (!ad.isEmpty()) {
				str += ad.removeLast();
			}

			int answer = -1;

			Deque<Integer> ar2 = new ArrayDeque<>();

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (Character.isDigit(c)) {
					ar2.addLast(Character.getNumericValue(c));
				} else {
					if (c == '+') {
						int a = ar2.removeLast();
						int b = ar2.removeLast();
						ar2.addLast(a + b);
					} else {
						int a = ar2.removeLast();
						int b = ar2.removeLast();
						ar2.addLast(a * b);
					}
				}
			}
			
			answer = ar2.removeLast();

			stb.append('#').append(t).append(' ').append(answer).append('\n');
		}

		System.out.println(stb);
	}
}
