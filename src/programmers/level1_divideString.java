package programmers;

import java.util.ArrayList;

public class level1_divideString {
    class Solution {
        public int solution(String s) {
            ArrayList<String> split = new ArrayList<>();
            int answer = 0;

            boolean end = false;

            while (!end) {
                char x = s.charAt(0);
                int count = 0;
                int elseCount = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (x == s.charAt(i)) {
                        count++;
                    } else {
                        elseCount++;
                    }

                    if (i == s.length() - 1) {
                        split.add(s);
                        end = true;
                        break;
                    }

                    if (count == elseCount) {
                        split.add(s.substring(0, i + 1));
                        s = s.substring(i + 1);
                        break;
                    }
                }
            }


            answer = split.size();

            return answer;
        }
    }
}
