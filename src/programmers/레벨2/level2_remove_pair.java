package programmers.레벨2;

import java.util.Stack;

public class level2_remove_pair {
    static class Solution {
        public int solution(String s) {
            Stack<Character> stack = new Stack();

            for (char c : s.toCharArray()) {
                if (stack.size() == 0) {
                    stack.push(c);
                    continue;
                }

                if (stack.peek() == c) {
                    stack.pop();
                    continue;
                }

                stack.push(c);
            }

            if(stack.size()>0){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution t = new Solution();
        t.solution("bbaabaa");
    }
}
