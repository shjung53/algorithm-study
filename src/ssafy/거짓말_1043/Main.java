package 거짓말_1043;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;

	static Set<Integer> truth;
	static int[] parent;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		truth = new HashSet<Integer>();
		answer = 0;

		st = new StringTokenizer(br.readLine().trim());
		int count = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < count; i++) {
			int person = Integer.parseInt(st.nextToken());
			truth.add(person);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int partyN = Integer.parseInt(st.nextToken()); // 파티에 온 사람 수
			
			for (int j = 0; j < partyN; j++) {
				int partyPerson = Integer.parseInt(st.nextToken());
			}
		}
		
		
		System.out.println(answer);

	}
}
