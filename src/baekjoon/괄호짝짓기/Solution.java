package 괄호짝짓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int num = Integer.parseInt(br.readLine());
			ArrayDeque<Character> stack = new ArrayDeque();

			String input = br.readLine();

			for (int i = 0; i < num; i++) {
				char braket = input.charAt(i);
				if (braket == '{' || braket == '[' || braket =='(' || braket == '<') {
					stack.push(braket);
				} else {
					switch (braket) {
					case '}': {
						if (stack.peek() == '{') {
							stack.pop();
						} else {
							stack.push(braket);
						}
					}
						break;
					case ']': {
						if (stack.peek() == '[') {
							stack.pop();
						} else {
							stack.push(braket);
						}
					}
						break;
					case ')': {
						if (stack.peek() == '(') {
							stack.pop();
						} else {
							stack.push(braket);
						}
					}
						break;
					case '>': {
						if (stack.peek() == '<') {
							stack.pop();
						} else {
							stack.push(braket);
						}
					}
					}
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("#" + t + " " + 1);
			}else {
				System.out.println("#" + t + " " + 0);
			}
		}
	}
}
