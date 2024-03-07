package baekjoon.그룹단어체커_1316;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;

    static int n;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        int count = 0;

        for(int i=0; i<n; i++) {
            HashSet<Character> set = new HashSet<>();
            String word = br.readLine().trim();
            set.add(word.charAt(0));
            boolean isGroup = true;
            for(int j=1; j<word.length(); j++) {
                if(word.charAt(j) == word.charAt(j - 1)) continue;
                if(!set.contains(word.charAt(j))) {
                    set.add(word.charAt(j));
                    continue;
                }
                isGroup = false;
            }

            if(isGroup) count++;
        }

        System.out.println(count);
    }
}
