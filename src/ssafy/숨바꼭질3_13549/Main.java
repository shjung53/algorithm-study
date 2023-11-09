package 숨바꼭질3_13549;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int k;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int time = 0;
		
	
		// 역순으로 간다.
		if(n < k) {
			String goal = Integer.toBinaryString(n);
			String start = Integer.toBinaryString(k);
		}else {
			String goal = Integer.toBinaryString(n);
			String start = Integer.toBinaryString(k);
		}
		String goal = Integer.toBinaryString(n);
		String start = Integer.toBinaryString(k);
		
		int teleport = start.length() - goal.length();
	}
}
