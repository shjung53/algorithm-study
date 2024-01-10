import java.util.*;
import java.io.*;

public class Main {
    static int s, p, left, right;
    static String str;
    static HashMap<Character, Integer> rule;
    static HashMap<Character, Integer> count;

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        int answer = 0;
        str = br.readLine().trim();

        rule = new HashMap<>();
        count = new HashMap<>();

        st = new StringTokenizer(br.readLine().trim());
        rule.put('A', Integer.parseInt(st.nextToken()));
        rule.put('C', Integer.parseInt(st.nextToken()));
        rule.put('G', Integer.parseInt(st.nextToken()));
        rule.put('T', Integer.parseInt(st.nextToken()));

        left = 0;
        right = p - 1;

        String password = str.substring(left, right + 1);

        for(char c : password.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        while(right < s) {
            if(count.getOrDefault('A', 0) < rule.getOrDefault('A', 0)) {
                if (moveRight()) break;
                continue;
            }
            if(count.getOrDefault('C', 0) < rule.getOrDefault('C', 0)) {
                if (moveRight()) break;
                continue;
            }
            if(count.getOrDefault('G', 0) < rule.getOrDefault('G', 0)) {
                if (moveRight()) break;
                continue;
            }
            if(count.getOrDefault('T', 0) < rule.getOrDefault('T', 0)) {
                if (moveRight()) break;
                continue;
            }
            answer++;
            if (moveRight()) break;
        }
        System.out.println(answer);
    }

    private static boolean moveRight() {
        count.put(str.charAt(left), count.getOrDefault(str.charAt(left), 0) - 1);
        left++;
        right++;
        if(right >= s) return true;
        count.put(str.charAt(right), count.getOrDefault(str.charAt(right), 0) + 1);
        return false;
    }
}
