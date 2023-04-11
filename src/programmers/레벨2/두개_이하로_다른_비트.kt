package programmers.레벨2

import kotlin.math.pow

/*
양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.

x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
예를 들어,

f(2) = 3 입니다. 다음 표와 같이 2보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 3이기 때문입니다.
수	비트	다른 비트의 개수
2	000...0010
3	000...0011	1
f(7) = 11 입니다. 다음 표와 같이 7보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 11이기 때문입니다.
수	비트	다른 비트의 개수
7	000...0111
8	000...1000	4
9	000...1001	3
10	000...1010	3
11	000...1011	2
정수들이 담긴 배열 numbers가 매개변수로 주어집니다. numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ numbers의 길이 ≤ 100,000
0 ≤ numbers의 모든 수 ≤ 1015
 */
class 두개_이하로_다른_비트 {

//    좀 잘푼 것 같다.
    fun 내풀이(numbers: LongArray): LongArray {
        var answer = LongArray(numbers.size)

        for (i in numbers.indices) {
            var number = numbers[i]
            var count = 0.0
//            가장 작은 경우는 1을 더했을 때 1개 혹은 2개의 최하위 비트가 변하는 것
//            +1 했을때 최하위 비트가 00이 되면 3개의 비트가 변하게 되고 4로 나누어 떨어진다.
//            해당 4로 나누어 떨어질 경우 right shift 하여 자릿수를 하나씩 올라가면서 안 나누어 떨어지는 경우를 찾는다.
            while ((number.toInt() + 1) % 4 == 0) {
                number = number shr 1
                count++
            }
            answer[i]= (numbers[i]+ 2.0.pow(count)).toLong()
        }

        return answer
    }
}