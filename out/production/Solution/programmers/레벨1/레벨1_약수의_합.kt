package programmers.레벨1

/*
정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

제한 사항
n은 0 이상 3000이하인 정수입니다.
 */
class 레벨1_약수의_합 {

    fun 내풀이(n: Int): Int {
        var answer = 0

        for (i in 1..n) {
            if (i * i > n) {
                break
            }
            if (n % i == 0) {
                if (i == n / i) {
                    answer += i
                } else {
                    answer += i
                    answer += n / i
                }
            }
        }
        return answer
    }

//    간결하지만 시간이 오래걸림
    fun 다른풀이(n: Int): Int {
        var answer = 0

        answer = (1..n).filter { n % it == 0 }.sum()

        return answer
    }
}