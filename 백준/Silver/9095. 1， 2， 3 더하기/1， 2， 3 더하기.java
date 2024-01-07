import java.io.*;

public class Main {
    static BufferedReader br;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testN = Integer.parseInt(br.readLine().trim());
        dp = new int[11]; // 11보다 작으므로 최대 정수n은 10까지
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int testCase = 1; testCase <= testN; testCase++) {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(getDp(n));
        }
    }

    private static int getDp(int num) {
        if (dp[num] == 0) {
            return dp[num] = getDp(num - 1) + getDp(num - 2) + getDp(num - 3);
        } else {
            return dp[num];
        }
    }

    /*
    1,2,3 으로만 덧셈을 구성해야 하므로 n-1에서 가능한 조합에서 1을 더하고
     n-2에서 가능한 조합에서 2를 더하고
     n-3에서 가능한 조합에서 3을 더하면
     현재의 경우의 수를 구할 수 있다.
     1   1+1   1+1+1   1+1+1+1
         2     2+1     2+1+1
               1+2     1+2+1
               3       1+1+2
                       2+2
                       3+1
                       1+3 
     */
}
