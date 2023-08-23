package 개미_10158;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());

		int x = p;
		int y = q;

		int restW = t % (2 * w);
		int restH = t % (2 * h);

		if (restW + p > w) {
			int overW = p + restW - w;
			if ((overW > w)) {
				x = overW - w;
			} else {
				x = w - overW;
			}
		} else {
			x = p + restW;
		}

		if (restH + q > h) {
			int overH = q + restH - h;
			if ((overH > h)) {
				y = overH - h;
			} else {
				y = h - overH;
			}
		} else {
			y = q + restH;
		}

		StringBuilder stb = new StringBuilder();

		System.out.println(stb.append(x).append(" ").append(y).toString());

	}
}
