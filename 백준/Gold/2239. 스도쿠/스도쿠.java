import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static BufferedReader br;
	static ArrayList<Integer> indexList;
	static StringBuilder stb;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		indexList = new ArrayList<>();
		stb = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			String st = br.readLine().trim();
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
				if (map[i][j] == 0)
					indexList.add(i * 9 + j);
			}
		}

		play(0);
	}

	private static void play(int index) {

		if (index == indexList.size()) {
			stb.setLength(0);
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					stb.append(map[i][j]);
				}
				stb.append('\n');
			}

			System.out.println(stb);
			System.exit(0);
			return;
		}

		int emptyIndex = indexList.get(index);

		int yIndex = emptyIndex / 9;
		int xIndex = emptyIndex % 9;

		for (int i = 1; i <= 9; i++) {

			if (!row(yIndex, xIndex, i))
				continue;

			if (!column(xIndex, yIndex, i))
				continue;

			if (!square(yIndex, xIndex, i))
				continue;

			map[yIndex][xIndex] = i;
			play(index + 1);
			map[yIndex][xIndex] = 0;
		}
	}

	static private boolean row(int yIndex, int xIndex, int num) {
		for (int i = 0; i < 9; i++) {
			if (i == xIndex)
				continue;
			if (map[yIndex][i] == num)
				return false;
		}
		return true;
	}

	static private boolean column(int xIndex, int yIndex, int num) {
		for (int i = 0; i < 9; i++) {
			if (i == yIndex)
				continue;
			if (map[i][xIndex] == num)
				return false;
		}
		return true;
	}

	static private boolean square(int y, int x, int num) {
		int startY = (y / 3) * 3;
		int startX = (x / 3) * 3;
		int endY = (y / 3) * 3 + 3;
		int endX = (x / 3) * 3 + 3;

		for (int i = startY; i < endY; i++) {
			for (int j = startX; j < endX; j++) {
				if (i == y && j == x)
					continue;
				if (map[i][j] == num)
					return false;
			}
		}
		return true;
	}
}
