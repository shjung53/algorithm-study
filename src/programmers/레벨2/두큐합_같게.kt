package programmers.레벨2

import java.util.*
import kotlin.collections.ArrayDeque

class 두큐합_같게 {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0

        val q1 = LinkedList<Int>()
        val q2 = LinkedList<Int>()
        var sum1 = 0L
        var sum2 = 0L
        val total = queue1 + queue2

        val case = LinkedList<Bfs>()

        for(i in queue1) {
            q1.addLast(i)
            sum1 += i
        }

        for(i in queue2) {
            q2.addLast(i)
            sum2 += i
        }

        Arrays.sort(total)

        if(!checkPossible(total, sum1 + sum2)) return -1

        case.offer(Bfs(LinkedList<Int>(q1), LinkedList<Int>(q2), sum1, sum2, 0, 1))
        case.offer(Bfs(LinkedList<Int>(q1), LinkedList<Int>(q2), sum1, sum2, 0, 2))

        while(case.isNotEmpty()) {
            val bfs = case.poll()
            if(bfs.sum1 == bfs.sum2) {
                answer = bfs.count
                break
            }

            if(bfs.q1.isEmpty() || bfs.q2.isEmpty()) continue

            if(bfs.turn == 1) {
                val poll = bfs.q1.poll()
                bfs.q2.offer(poll)
                case.offer(Bfs(LinkedList<Int>(bfs.q1), LinkedList<Int>(bfs.q2), bfs.sum1 - poll, bfs.sum2 + poll, bfs.count+1, 1))
                case.offer(Bfs(LinkedList<Int>(bfs.q1), LinkedList<Int>(bfs.q2), bfs.sum1 - poll, bfs.sum2 + poll, bfs.count+1, 2))
            } else {
                val poll = bfs.q2.poll()
                bfs.q1.offer(poll)
                case.offer(Bfs(LinkedList<Int>(bfs.q1), LinkedList<Int>(bfs.q2), bfs.sum1 + poll, bfs.sum2 - poll, bfs.count+1, 1))
                case.offer(Bfs(LinkedList<Int>(bfs.q1), LinkedList<Int>(bfs.q2), bfs.sum1 + poll, bfs.sum2 - poll, bfs.count+1, 2))
            }

        }
        return answer
    }

    private fun checkPossible(total: IntArray, sum: Long): Boolean {
        if(sum and 1L == 1L) return false
        val queue = LinkedList<Check>()

        queue.offer(Check(0, 0, sum / 2, total))

        while (queue.isNotEmpty()) {
            val check = queue.poll()
            if(check.count == check.goal) return true
            if(check.idx == total.lastIndex) continue
            queue.offer(Check(check.idx + 1, check.count, check.goal, check.total))
            queue.offer(Check(check.idx + 1, check.count + total[check.idx], check.goal, check.total))
        }
        return false
    }

    class Bfs(val q1: LinkedList<Int>, val q2: LinkedList<Int>, val sum1: Long, val sum2: Long, val count: Int, val turn: Int)
    class Check(val idx: Int, val count: Long, val goal: Long, val total: IntArray)
}

fun main() {
    val a = 두큐합_같게()
    a.solution(intArrayOf(3,2,7,2), intArrayOf(4,6,5,1))
}