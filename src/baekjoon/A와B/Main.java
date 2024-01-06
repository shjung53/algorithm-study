package A와B;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();

		String s = br.readLine().trim();
		String t = br.readLine().trim();

		// s랑 t의 길이가 같아질때까지
		while (s.length() < t.length()) {
			// 마지막이 A냐 B냐에 따라 달라짐
			if (t.charAt(t.length() - 1) == 'A') {
				// 마지막 A를 뺀다.
				t = t.substring(0, t.length() - 1);
			} else {
				// 마지막 B를 빼고 뒤집는다.
				t = t.substring(0, t.length() - 1);
				stb.setLength(0);
				stb.append(t);
				stb.reverse();
				t = stb.toString();
			}
		}

		if (s.equals(t)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
