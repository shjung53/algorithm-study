import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;

    static int n, length, number, answer, cal;

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        length = str.length();
        arr = new int[length];
        visited = new boolean[length];
        n = Integer.parseInt(str);
        number = n;

        for (int i = length - 1; i >= 0; i--) {
            int divider = (int) Math.pow(10, i);
            arr[i] = n / divider;
            n -= arr[i] * divider;
        }

        cal = 0;
        answer = 1000000;

        makeNumber(0);

        if(answer == 1000000) answer =0;

        System.out.println(answer);

    }

    private static void makeNumber(int idx){

        if(idx >= length) {
            if(cal > number && cal < answer) answer = cal;
            return;
        }

        for(int i=0; i<length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            cal = cal * 10 + arr[i];
            makeNumber(idx + 1);
            visited[i] = false;
            cal /= 10;
        }
    }
}
