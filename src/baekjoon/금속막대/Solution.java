package 금속막대;

import java.util.*;
import java.io.*;

/**
 * 
 * @author SSAFY
 *
 *         1. 맨 앞에 올 볼트 선정 2. 이어질 볼트를 넣기
 */

public class Solution {

	static Bolt[] bolts;
	static Map<Integer, Bolt> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= testCase; tc++) {
			int boltCount = Integer.parseInt(br.readLine().trim());
			bolts = new Bolt[boltCount];
			map = new HashMap<>();
			Bolt preBolt = null;
			stb.append('#').append(tc).append(' ');

			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < boltCount; i++) {
				bolts[i] = new Bolt(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				map.put(bolts[i].male, bolts[i]);
			}

			for (int i = 0; i < boltCount; i++) {
				boolean isFirst = true;
				int male = bolts[i].male;
				for (int j = 0; j < boltCount; j++) {
					if (bolts[j].female == male)
						isFirst = false;
				}
				if (isFirst) {
					preBolt = bolts[i];
					break;
				}
			}

			stb.append(preBolt.male).append(' ').append(preBolt.female);

			for (int i = 1; i < boltCount; i++) {
				preBolt = map.get(preBolt.female);
				stb.append(' ').append(preBolt.male).append(' ').append(preBolt.female);
			}
			stb.append('\n');

		}

		System.out.println(stb.toString());
	}

	public static void selectFirst() {
	}
}

class Bolt {
	int male;
	int female;

	public Bolt(int male, int female) {
		super();
		this.male = male;
		this.female = female;
	}

	@Override
	public String toString() {
		return "Bolt [male=" + male + ", female=" + female + "]";
	}

}
