package Fibo;

public class Fibo {
	static int[] memo = new int[100];

	public static void main(String[] args) {
		System.out.println(fibo(45));
	}

	public static int fibo(int n) {
		if (n < 2)
			return memo[n] = n;
		if (memo[n] == 0) {
			return memo[n] = (fibo(n - 1) + fibo(n - 2));
		} else {
			return memo[n];
		}
	}

}
