package programmers.레벨1

class 레벨1_정수_제곱근_판별 {
    fun 내풀이(n: Long): Long {
        var answer: Long = -1

        for(i in 1..n){
            if(i*i>n){
                return -1
            }
            if(i*i==n){
                return (i+1)*(i+1)
            }
        }
        return answer
    }
}