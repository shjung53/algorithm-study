package programmers.레벨1

class 레벨1_짝수와_홀수 {

    //    비트연산
    fun 내풀이(num: Int): String {
        var answer = ""
        return if (num and 1 == 1) {
            "Odd"
        } else {
            "Even"
        }
    }

    //    %연산
    fun 내풀이2(num: Int): String {
        var answer = ""

        return if (num % 2 == 0) {
            "Even"
        } else {
            "Odd"
        }
    }
}