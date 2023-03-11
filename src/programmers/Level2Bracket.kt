package programmers

import kotlin.math.ceil

class Level2Bracket {
    class Solution {
        fun solution(n: Int, a: Int, b: Int): Int {
            var answer = 0
            var doubleA: Double = a.toDouble()
            var doubleB: Double = b.toDouble()

            while(doubleA != doubleB){
                answer++
                doubleA = ceil(doubleA/2)
                doubleB = ceil(doubleB/2)
            }

            return answer
        }
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            val s: Int = Solution().solution(8,4,7)
            println(s)
        }
    }
}