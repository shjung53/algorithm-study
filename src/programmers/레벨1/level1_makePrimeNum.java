package programmers.레벨1;

public class level1_makePrimeNum {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;

            for(int i=0; i<nums.length-2; i++){
                for(int j=i+1; j<nums.length-1; j++){
                    for(int k=j+1; k<nums.length; k++){
                        boolean check=true;
                        for (int l = 2; l*l <= nums[i]+nums[j]+nums[k]; l++) {
                            if ((nums[i]+nums[j]+nums[k]) % l == 0){
                                check=false;
                                break;
                            }
                        }
                        if(check){answer++;}
                    }
                }
            }

            return answer;
        }
    }
}
