package programmers.레벨2

/*
한국중학교에 다니는 학생들은 각자 정수 번호를 갖고 있습니다. 이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사라고 합니다. 예를 들어, 5명의 학생이 있고, 각각의 정수 번호가 순서대로 -2, 3, 0, 2, -5일 때, 첫 번째, 세 번째, 네 번째 학생의 정수 번호를 더하면 0이므로 세 학생은 삼총사입니다. 또한, 두 번째, 네 번째, 다섯 번째 학생의 정수 번호를 더해도 0이므로 세 학생도 삼총사입니다. 따라서 이 경우 한국중학교에서는 두 가지 방법으로 삼총사를 만들 수 있습니다.

한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때, 학생들 중 삼총사를 만들 수 있는 방법의 수를 return 하도록 solution 함수를 완성하세요.

제한사항
3 ≤ number의 길이 ≤ 13
-1,000 ≤ number의 각 원소 ≤ 1,000
서로 다른 학생의 정수 번호가 같을 수 있습니다.
 */
class 삼총사 {

    var answer = 0
    fun 내풀이(number: IntArray): Int {

        var answer: Int = 0

        for(i in 0 .. number.lastIndex-2){
            for(j in i+1 until number.lastIndex){
                for(k in j+1 .. number.lastIndex){
                    if(number[i]+number[j]+number[k]==0){
                        answer++
                    }
                }
            }
        }

        return answer
    }

//    DFS 확인해두기
    fun 다른풀이(number: IntArray): Int {

        val visit = BooleanArray(number.size) { false }

        dfs(0, 0, number, visit)

        return answer
    }

    private fun dfs(idx: Int, cnt: Int, number: IntArray, visit: BooleanArray) {

        if (cnt == 3) {
            var sum = 0

            for (i in number.indices) {
                if (visit[i]) {
                    sum += number[i]
                }
            }

            if (sum == 0) answer++
            return
        }

        for (i in idx until number.size) {
            if (visit[i]) continue

            visit[i] = true
            dfs(i, cnt + 1, number, visit)
            visit[i] = false
        }
    }

}

fun main() {
    val a = 삼총사()
    a.solution(intArrayOf(3,2,6,8,-8,0))
}
