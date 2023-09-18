package k번째문자열;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int k = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String answer = "";
			TreeSet<String> tree = new TreeSet<>();

			for (int i = 0; i < str.length(); i++) {
				for (int j = i + 1; j <= str.length(); j++) {
					tree.add(str.substring(i, j));
				}
			}

			for (int i = 1; i <= k; i++) {
				answer = tree.pollFirst();
			}

			if (answer == null)
				answer = "none";

			stb.append('#').append(tc).append(' ').append(answer).append('\n');
		}

		System.out.println(stb.toString());
	}
}
