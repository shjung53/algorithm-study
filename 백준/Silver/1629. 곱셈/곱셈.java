import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(myPow(a, b, c));
	}

	static long myPow(int a, int b, int c) {
		if (b == 0)
			return 1;

		long n = myPow(a, b / 2, c);

		if (b % 2 == 0) {
			return n * n % c;
		} else {
			return (n * n % c) * a % c;
		}
	}
}
