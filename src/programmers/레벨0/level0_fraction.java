package programmers.레벨0;

import java.math.BigInteger;

public class level0_fraction {
    class Solution {
        public int[] solution(int numer1, int denom1, int numer2, int denom2) {
            int[] answer = new int[2];

            BigInteger newNumer = BigInteger.valueOf(numer1*denom2 + numer2*denom1);
            BigInteger newDenom = BigInteger.valueOf(denom1*denom2);
            BigInteger gcd = newNumer.gcd(newDenom);
            if(gcd.intValue()>0){
                answer[0] = newNumer.intValue()/gcd.intValue();
                answer[1] = newDenom.intValue()/gcd.intValue();
            }

            return answer;
        }
    }
}
