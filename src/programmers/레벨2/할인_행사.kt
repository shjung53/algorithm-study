package programmers.레벨2

class 할인_행사 {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        val wants = HashMap<String,Int>()
        val items = HashMap<String,Int>()

        for(i in want.indices){
            for(j in 1 .. number[i]){
                wants[want[i]] = wants.getOrDefault(want[i],0)+1
            }
        }

        out@
        for(i in 0 .. discount.size-10){
            for(j in i .. i+9){
                items[discount[j]] = items.getOrDefault(discount[j],0)+1
            }
            for(item in items.keys){
                if(wants[item]==null || wants[item] != items[item]){
                    items.clear()
                    continue@out
                }
            }
            answer++
            items.clear()
        }

        return answer
    }
}

fun main() {
    val a = 할인_행사()
    a.solution(arrayOf("banana", "apple", "rice", "pork", "pot"),	intArrayOf(3, 2, 2, 2, 1),	arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"))
}
