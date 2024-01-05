package 종이자르기_2628;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		int answerWidth = 0;
		int answerHeight = 0;

		int cutCount = Integer.parseInt(br.readLine());

		int[] widthDevide = new int[width + 1];
		int[] heightDevide = new int[height + 1];

		for (int i = 0; i < cutCount; i++) {
			st = new StringTokenizer(br.readLine());
			int rowCol = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (rowCol == 0) {
				heightDevide[num] = 1;
			} else {
				widthDevide[num] = 1;
			}
		}

		int preCutted = 0;

		for (int i = 1; i < widthDevide.length; i++) {

			if (i == width) {
				if(width - preCutted > answerWidth) answerWidth = width - preCutted;
			}

			if (widthDevide[i] != 1)
				continue;

			if (i - preCutted > answerWidth)
				answerWidth = i - preCutted;
			
			preCutted = i;

		}

		preCutted = 0;

		for (int i = 1; i < heightDevide.length; i++) {

			if (i == height) {
				if(height - preCutted > answerHeight) answerHeight = height - preCutted;
			}

			if (heightDevide[i] != 1)
				continue;

			if (i - preCutted > answerHeight)
				answerHeight = i - preCutted;
			preCutted = i;

		}

		if (answerWidth == 0)
			answerWidth = width;
		if (answerHeight == 0)
			answerHeight = height;

		System.out.println(answerWidth * answerHeight);
	}
}
