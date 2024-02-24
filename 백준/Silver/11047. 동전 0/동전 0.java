import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    static int n, k, count, left;

    static int[] unit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        count = 0;
        left = k;

        unit = new int[n];

        for (int i = 0; i < n; i++) {
            unit[i] = Integer.parseInt(br.readLine().trim());
        }

        int idx = n - 1;

        while(left > 0) {
            if(unit[idx] > left) {
                idx--;
                continue;
            }

            int quotient = left / unit[idx];

            count += quotient;
            left -= quotient * unit[idx];

            idx--;
        }

        System.out.println(count);

    }
}
