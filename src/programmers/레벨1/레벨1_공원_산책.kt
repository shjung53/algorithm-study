package programmers.레벨1

class 레벨1_공원_산책 {
    fun 내풀이(park: Array<String>, routes: Array<String>): IntArray {
        var answer = IntArray(2)
        val hLimit = park.size - 1
        val wLimit = park[0].length - 1

        for (i in park.indices) {
            if (park[i].contains('S')) {
                answer = intArrayOf(i, park[i].indexOf('S'))
            }
        }

        for (order in routes) {
            if (order.split(" ")[0] == "N") {
                if (checkLimit(answer[0], -1 * order.split(" ")[1].toInt(), hLimit)) {
                    continue
                }
                for(i in answer[0] downTo answer[0]-order.split(" ")[1].toInt()){
                    if(park[i][answer[1]]=='X'){
                        continue
                    }
                }
                answer[0] -= order.split(" ")[1].toInt()
            } else if (order.split(" ")[0] == "S") {
                if (checkLimit(answer[0], order.split(" ")[1].toInt(), hLimit)) {
                    continue
                }
                for(i in answer[0] .. answer[0]+order.split(" ")[1].toInt()){
                    if(park[i][answer[1]]=='X'){
                        continue
                    }
                }
                answer[0] += order.split(" ")[1].toInt()
            } else if (order.split(" ")[0] == "W") {
                if (checkLimit(answer[1], -1 * order.split(" ")[1].toInt(), wLimit)) {
                    continue
                }
                for(i in answer[1] downTo  answer[1]-order.split(" ")[1].toInt()){
                    if(park[answer[0]][i]=='X'){
                        continue
                    }
                }
                answer[1] -= order.split(" ")[1].toInt()

            } else {
                if (checkLimit(answer[1], order.split(" ")[1].toInt(), wLimit)) {
                    continue
                }
                for(i in answer[1] ..  answer[1]+order.split(" ")[1].toInt()){
                    if(park[answer[0]][i]=='X'){
                        continue
                    }
                }
                answer[1] += order.split(" ")[1].toInt()
            }
        }

        return answer
    }

    //    limit 벗어나면 true
    fun checkLimit(pos: Int, move: Int, limit: Int): Boolean {
        return pos + move < 0 || pos + move > limit
    }
}

fun main() {
    val a = 레벨1_공원_산책()
    a.내풀이(arrayOf("SOO", "OXX", "OOO"), arrayOf("E 2", "S 2", "W 1"))
}