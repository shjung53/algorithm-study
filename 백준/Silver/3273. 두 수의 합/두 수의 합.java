import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int[] arr;
    static int n, x, answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        arr = new int[n];
        answer = 0;

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (arr[left] + arr[right] == x) {
                answer++;
                left++;
                right--;
                continue;
            }

            if(arr[left] + arr[right] > x) {
                right--;
                continue;
            }

            if(arr[left] + arr[right] < x) {
                left++;
                continue;
            }
        }

        System.out.println(answer);
    }
}
