package baekjoon.괄호_9012;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());

        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            boolean isVPS = true;
            ArrayDeque<Character> stack = new ArrayDeque<>();
            String str = br.readLine().trim();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == ')') {
                    if(stack.isEmpty()) isVPS = false;
                    while (!stack.isEmpty()) {
                        if (stack.pop() == '(') {
                            break;
                        }
                    }
                } else {
                    stack.push(c);
                }

            }

            if(!stack.isEmpty()) isVPS = false;

            if (isVPS) {
                stb.append("YES").append('\n');
            } else {
                stb.append("NO").append('\n');
            }
        }

        System.out.println(stb);
    }
}
