package 비밀번호;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			ArrayDeque<Character> arrayDeque = new ArrayDeque();
			for (int i = 0; i < num; i++) {
				if (arrayDeque.isEmpty()) {
					arrayDeque.addLast(str.charAt(i));
				} else {
					if (arrayDeque.peekLast() == str.charAt(i)) {
						arrayDeque.removeLast();
					} else {
						arrayDeque.addLast(str.charAt(i));
					}
				}
			}
			String answer = "";
			while (!arrayDeque.isEmpty()) {answer += arrayDeque.removeFirst();}
			System.out.println("#" + t + " " + answer);
		}
	}
}
