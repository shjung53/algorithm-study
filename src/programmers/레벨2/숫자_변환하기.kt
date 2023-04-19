package programmers.레벨2

import java.util.*

/*
자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.

x에 n을 더합니다
x에 2를 곱합니다.
x에 3을 곱합니다.
자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.

제한사항
1 ≤ x ≤ y ≤ 1,000,000
1 ≤ n < y
 */

class 숫자_변환하기 {
    fun solution(x: Int, y: Int, n: Int): Int {
        var answer: Int = 0

        val queue = LinkedList<Int>()
        val checkDuplication = mutableSetOf<Int>()

        if(x == y) return 0

        queue.offer(x)
        checkDuplication.add(x)

        while (queue.isNotEmpty()) {
            answer++
            for (i in 1..queue.size) {
                val num = queue.pop()
                if (num + n == y || num * 2 == y || num * 3 == y) {
                    return answer
                } else {
                    if (num + n < y && !checkDuplication.contains(num + n)) {
                        queue.offer(num + n)
                        checkDuplication.add(num + n)
                    }
                    if (num * 2 < y && !checkDuplication.contains(num * 2)) {
                        queue.offer(num * 2)
                        checkDuplication.add(num * 2)
                    }
                    if (num * 3 < y && !checkDuplication.contains(num * 3)) {
                        queue.offer(num * 3)
                        checkDuplication.add(num * 3)
                    }

                }
            }
        }

        answer = -1

        return answer
    }
}