package 평범한배낭_12865;

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
 
		int[] W = new int[n + 1]; // 무게
		int[] V = new int[n + 1]; // 가치
		int[] dp = new int[k + 1];
 
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
 
		for (int i = 1; i <= n; i++) {
			
			// K부터 탐색하여 담을 수 있는 무게 한계치가 넘지 않을 때까지 반복 
			for (int j = k; j - W[i] >= 0; j--) {
				dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
			}
		}
		System.out.println(dp[k]);
	}
}
