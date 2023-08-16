package programmers.레벨2

import java.util.*
import kotlin.collections.ArrayDeque

class 두큐합_같게 {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer1: Int = 0
        var answer2: Int = 0

        val total = queue1 + queue2

        val totalCount = queue1.size + queue2.size

        Arrays.sort(total)

        val totalSum = total.sum()

        if (totalSum and 1 == 1) return -1
        val goal = totalSum shr 1

        var sum = 0

        for (i in total) {
            sum += i
            if (sum == goal) break
        }

        val circular1 = queue1 + queue2 + queue1

        var left = 0
        var right = 0
        sum = 0

        sum += circular1[right]

        while (sum != goal) {
            if (left > right) return -1
            if (sum > goal) {
                sum -= circular1[left]
                left++
            } else {
                if (right >= circular1.size - 1) return -1
                if (right - left <= totalCount - 2) {
                    right++
                    sum += circular1[right]
                }
            }
        }
        if (left < queue1.size) {
            if(right < queue1.size + queue2.size) {
                answer1 += left + right - queue1.size + 1
            } else {
                answer1 += right
            }
        } else {
            if(right < queue1.size + queue2.size) {
                answer1 += queue1.size + right - left + 1
            } else {
                answer1 += right - queue1.size - queue2.size
            }
        }

        left = 0
        right = 0
        val circular2 = queue2 + queue1 + queue2
        sum = 0
        sum += circular2[right]

        while (sum != goal) {
            if (left > right) return -1
            if (sum > goal) {
                sum -= circular2[left]
                left++
            } else {
                if (right >= circular2.size - 1) return -1
                if (right - left <= totalCount - 2) {
                    right++
                    sum += circular2[right]
                }
            }
        }
        if (left < queue2.size) {
            if(right < queue2.size + queue1.size) {
                answer2 += left + right - queue2.size + 1
            } else {
                answer2 += right
            }
        } else {
            if(right < queue2.size + queue1.size) {
                answer2 += queue2.size + right - left + 1
            } else {
                answer2 += right - queue2.size - queue1.size
            }
        }

        return minOf(answer1, answer2)
    }
}

fun main() {
    val a = 두큐합_같게()
    a.solution(intArrayOf(3,2,7,2), intArrayOf(4,6,5,1))
}