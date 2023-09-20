package 보호필름;

import java.util.*;
import java.io.*;

public class Solution {

	static BufferedReader br;
	static StringTokenizer st;
	static int filmDepth;
	static int filmWidth;
	static int standard;
	static int[][] firstFilm;
	static boolean[] select;
	static int count;
	static boolean check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc < testCase + 1; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			filmDepth = Integer.parseInt(st.nextToken());
			filmWidth = Integer.parseInt(st.nextToken());
			standard = Integer.parseInt(st.nextToken());
			count = Integer.MAX_VALUE;
			check = false;

			firstFilm = new int[filmDepth][filmWidth];

			for (int depthIdx = 0; depthIdx < filmDepth; depthIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int widthIdx = 0; widthIdx < filmWidth; widthIdx++) {
					firstFilm[depthIdx][widthIdx] = Integer.parseInt(st.nextToken());
				}
			}

			for (int selectCount = 0; selectCount <= filmDepth; selectCount++) {
				select = new boolean[filmDepth];
				if (check)
					break;
				combination(0, selectCount, 0);
			}
			stb.append('#').append(tc).append(' ').append(count).append('\n');
		}
		System.out.println(stb.toString());
	}

	// 약물 투입할 행을 선택
	private static void combination(int count, int selectCount, int rowIdx) {
		if (check)
			return;
		if (count == selectCount) {
			inject(0, firstFilm, selectCount);
			return;
		}

		if (rowIdx >= filmDepth)
			return;

		select[rowIdx] = true;
		combination(count + 1, selectCount, rowIdx + 1);
		select[rowIdx] = false;
		combination(count, selectCount, rowIdx + 1);

	}

	private static void inject(int rowIdx, int[][] film, int selectCount) {
		if (check)
			return;
		if (rowIdx >= filmDepth) {
			if (checkFilm(film)) {
				count = selectCount;
				check = true;
			}
			return;
		}

		if (select[rowIdx]) {
			int[][] newFilm = deepCopy(film);
			chemicalInjection(newFilm, rowIdx, 0);
			inject(rowIdx + 1, newFilm, selectCount);
			chemicalInjection(newFilm, rowIdx, 1);
			inject(rowIdx + 1, newFilm, selectCount);
		} else {
			inject(rowIdx + 1, film, selectCount);
		}
	}

	private static boolean checkFilm(int[][] film) {
		boolean filmTest = true;

		// 연속된 3개의 값이 있는 열은 패스, 실패하면 필름테스트 실패
		for (int colIdx = 0; colIdx < filmWidth; colIdx++) {
			int count = 1;
			boolean colTest = false;
			for (int rowIdx = 1; rowIdx < filmDepth; rowIdx++) {
				if (film[rowIdx][colIdx] == film[rowIdx - 1][colIdx]) {
					count++;
				} else {
					count = 1;
				}
				if (count == standard)
					colTest = true;
			}

			if (!colTest) {
				filmTest = false;
				break;
			}
		}
		return filmTest;
	}

	private static void chemicalInjection(int[][] film, int rowIdx, int kind) {
		for (int colIdx = 0; colIdx < film[rowIdx].length; colIdx++) {
			film[rowIdx][colIdx] = kind;
		}
	}

	private static int[][] deepCopy(int[][] film) {
		int[][] newFilm = new int[filmDepth][filmWidth];
		for (int rowIdx = 0; rowIdx < film.length; rowIdx++) {
			newFilm[rowIdx] = film[rowIdx].clone();
		}
		return newFilm;
	}
}
