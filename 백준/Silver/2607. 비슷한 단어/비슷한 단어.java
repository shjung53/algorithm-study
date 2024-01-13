import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        String standard = br.readLine().trim();
        int answer = 0;

        Loop:
        for (int i = 0; i < n - 1; i++) {
            String str = br.readLine().trim();
            int lengthDiff = standard.length() - str.length();

            if (Math.abs(lengthDiff) > 1) continue;
            int[] arr = new int[26];

            for (char c : standard.toCharArray()) {
                arr[c - 'A']++;
            }

            for (char c : str.toCharArray()) {
                arr[c - 'A']--;
            }

            int diffCount = 0;

            if (lengthDiff == 1) {
                for (int count : arr) {
                    if (count < 0) continue Loop;
                }
            } else if (lengthDiff == 0) {
                for (int count : arr) {
                    if (count != 0) diffCount+= Math.abs(count);
                }
            } else if (lengthDiff == -1) {
                for (int count : arr) {
                    if (count > 0) continue Loop;
                }
            }

            if (diffCount > 2) continue;
            answer++;
        }

        System.out.println(answer);
    }
}
