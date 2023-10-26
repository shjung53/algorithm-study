package 이가빠진이진트리_26260;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] tree; //
	static int[] values;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());

		tree = new int[n + 1]; // 1번 노드부터 n번 노드까지
		values = new int[n]; // value는 n개
		int erasedIdx = -1;

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 1; i <= n; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (value == -1)
				erasedIdx = i;
		}

		values[erasedIdx] = Integer.parseInt(br.readLine().trim());
		
		Arrays.sort(values);
		
		for(int i=0; i<n; i++) {
			tree[]
		}

	}
}

