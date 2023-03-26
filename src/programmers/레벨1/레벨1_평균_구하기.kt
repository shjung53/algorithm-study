package programmers.레벨1

class 레벨1_평균_구하기 {

    //느리다. average()가 안좋은 듯 하다.
    fun 내풀이(arr: IntArray): Double {
        var answer = 0.0

        answer = arr.average()

        return answer
    }


    //이게 훨씬 빠르다
    fun 내풀이2(arr: IntArray): Double {
        var answer = 0.0

        for(i in arr){
            answer += i
        }

        answer /= arr.size

        return answer
    }
}