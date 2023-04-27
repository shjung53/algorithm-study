package programmers.레벨2

import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0

        val q1 = LinkedList<Int>()
        val q2 = LinkedList<Int>()
        var sum1 = 0L
        var sum2 = 0L

        val case = LinkedList<Bfs>()

        for(i in queue1) {
            q1.addLast(i)
            sum1 += i
        }

        for(i in queue2) {
            q2.addLast(i)
            sum2 += i
        }

        if(sum1 == sum2) return 0

        case.offer(Bfs(q1, q2, sum1, sum2, 0, 1))
        case.offer(Bfs(q1, q2, sum1, sum2, 0, 2))

        while(case.isNotEmpty()) {
            val bfs = case.poll()
            if(bfs.sum1 == bfs.sum2) {
                answer = bfs.count
                break
            }

            if(bfs.turn == 1) {
                val poll = bfs.q1.poll()
                bfs.sum1 -= poll
                bfs.q2.offer(poll)
                bfs.sum2 += poll
                case.offer(Bfs(bfs.q1, bfs.q2, bfs.sum1, bfs.sum2, bfs.count++, 1))
                case.offer(Bfs(bfs.q1, bfs.q2, bfs.sum1, bfs.sum2, bfs.count++, 2))
            } else {
                val poll = bfs.q2.poll()
                bfs.sum2 -= poll
                bfs.q1.offer(poll)
                bfs.sum1 += poll
                case.offer(Bfs(bfs.q1, bfs.q2, bfs.sum1, bfs.sum2, bfs.count++, 1))
                case.offer(Bfs(bfs.q1, bfs.q2, bfs.sum1, bfs.sum2, bfs.count++, 2))
            }

        }
        return answer
    }

    class Bfs(val q1: LinkedList<Int>, val q2: LinkedList<Int>, var sum1: Long, var sum2: Long, var count: Int, var turn: Int)
}