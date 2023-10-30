package ¿ÕÀ§°è½Â_5021;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static HashMap<String, Double> bloodMap;
	static HashMap<String, Integer> genMap;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		bloodMap = new HashMap<String, Double>();
		genMap = new HashMap<String, Integer>();
		String ancestor = br.readLine().trim();
		bloodMap.put(ancestor, 1.0);
		genMap.put(ancestor, 1);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			String child = st.nextToken();
			String father = st.nextToken();
			String mother = st.nextToken();
			double fatherBlood = bloodMap.getOrDefault(father, 0.0);
			double motherBlood = bloodMap.getOrDefault(mother, 0.0);

			int gen = Math.min(genMap.getOrDefault(father, 100), genMap.getOrDefault(mother, 100));
			bloodMap.put(child, (fatherBlood + motherBlood) / 2);
			genMap.put(child, gen + 1);
		}

		String nextKing = "";

		for (int i = 0; i < m; i++) {
			String candidate = br.readLine().trim();
			if (nextKing.equals("")) {
				nextKing = candidate;
				continue;
			}

			if (bloodMap.getOrDefault(candidate, 1.0) >= bloodMap.getOrDefault(nextKing, 1.0)) {
				if (genMap.getOrDefault(candidate, 100) < bloodMap.getOrDefault(nextKing, 1.0)) {
					nextKing = candidate;
				}
			}
		}

		System.out.println(nextKing);
	}
}
