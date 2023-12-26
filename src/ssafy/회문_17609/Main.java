package ssafy.회문_17609;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String str = br.readLine().trim();

            int left = 0;
            int right = str.length() - 1;
            int isPalindrome = 0;

            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    StringBuilder deleteLeft = new StringBuilder(str).deleteCharAt(left);
                    StringBuilder deleteRight = new StringBuilder(str).deleteCharAt(right);

                    if (deleteRight.toString().equals(deleteRight.reverse().toString())
                            || deleteLeft.toString().equals(deleteLeft.reverse().toString())) {
                        isPalindrome = 1;
                    }else {
                        isPalindrome = 2;
                    }
                    break;
                }

                left++;
                right--;

            }
            answer.append(isPalindrome).append('\n');
        }
        System.out.println(answer);
    }
}
