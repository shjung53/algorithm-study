package programmers.레벨2

import java.util.*

class 숫자_변환하기 {
    fun solution(x: Int, y: Int, n: Int): Int {
        var answer: Int = 0

        val queue = LinkedList<Int>()
        val checkDuplication = mutableSetOf<Int>()

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