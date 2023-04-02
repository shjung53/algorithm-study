package programmers.레벨2


/*
피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

예를들어

F(2) = F(0) + F(1) = 0 + 1 = 1
F(3) = F(1) + F(2) = 1 + 1 = 2
F(4) = F(2) + F(3) = 1 + 2 = 3
F(5) = F(3) + F(4) = 2 + 3 = 5
와 같이 이어집니다.

2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

제한 사항
n은 2 이상 100,000 이하인 자연수입니다.
 */
class 피보나치_수 {

    val arr = IntArray(100001)
    fun 내풀이(n: Int): Int {
        var answer = 0

        arr[0] = 0
        arr[1] = 1

        answer = fiboFibonacci(n)

        return answer
    }

    //    i가 크면 숫자의 범위가 너무 커져서 미리 나눠주어야 한다.
    fun fiboFibonacci(i: Int): Int {
        if (i == 0) return 0
        if (i == 1) return 1
        return if (arr[i] == 0) {
            arr[i] = (fiboFibonacci(i - 1) + fiboFibonacci(i - 2)) % 1234567
            arr[i]
        } else {
            arr[i]
        }
    }
}
