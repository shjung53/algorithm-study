import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim();
		String temp = "";

		int plus = 0;
		int minus = 0;

		// 마이너스에 더하는 중인지
		boolean isMinus = false;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c == '-') {
				if (!isMinus) {
					plus += Integer.parseInt(temp);
				} else {
					minus += Integer.parseInt(temp);
				}
				isMinus = true;
				temp = "";
				continue;
			}

			if (c == '+') {
				if (!isMinus) {
					plus += Integer.parseInt(temp);
				} else {
					minus += Integer.parseInt(temp);
				}
				temp = "";
				continue;
			}

			temp += c;

			if (i == input.length() - 1) {
				if (!isMinus) {
					plus += Integer.parseInt(temp);
				} else {
					minus += Integer.parseInt(temp);
				}
			}
		}

		System.out.println(plus - minus);
	}
}
