package 직사각형;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sq1x1 = Integer.parseInt(st.nextToken());
			int sq1y1 = Integer.parseInt(st.nextToken());
			int sq1x2 = Integer.parseInt(st.nextToken());
			int sq1y2 = Integer.parseInt(st.nextToken());
			int sq2x1 = Integer.parseInt(st.nextToken());
			int sq2y1 = Integer.parseInt(st.nextToken());
			int sq2x2 = Integer.parseInt(st.nextToken());
			int sq2y2 = Integer.parseInt(st.nextToken());

			int sq1BigX = Math.max(sq1x1, sq1x2);
			int sq1SmallX = Math.min(sq1x1, sq1x2);
			int sq1BigY = Math.max(sq1y1, sq1y2);
			int sq1SmallY = Math.min(sq1y1, sq1y2);
			int sq2BigX = Math.max(sq2x1, sq2x2);
			int sq2SmallX = Math.min(sq2x1, sq2x2);
			int sq2BigY = Math.max(sq2y1, sq2y2);
			int sq2SmallY = Math.min(sq2y1, sq2y2);

			boolean yMeet = false;
			boolean xMeet = false;
			boolean xNotMeet = false;
			boolean yNotMeet = false;

			String answer = "";

			if (sq1BigX == sq2SmallX || sq2BigX == sq1SmallX)
				xMeet = true;

			if (sq1BigY == sq2SmallY || sq2BigY == sq1SmallY)
				yMeet = true;

			if ((sq1SmallX > sq2BigX) || (sq2SmallX > sq1BigX)) {
				xNotMeet = true;
			}

			if ((sq1SmallY > sq2SmallY && sq1SmallY > sq2BigY) || (sq2SmallY > sq1SmallY && sq2SmallY > sq1BigY)) {
				yNotMeet = true;
			}

			if (xNotMeet || yNotMeet) {
				answer = "d";
			} else if (xMeet && yMeet) {
				answer = "c";
			} else if (xMeet || yMeet) {
				answer = "b";
			} else {
				answer = "a";
			}
			System.out.println(answer);
		}

	}
}
