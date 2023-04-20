package programmers.레벨2

class 소수찾기 {
    val duplication = mutableSetOf<Int>()

    fun solution(numbers: String): Int {
        var answer = 0

        val visited = Array<Boolean>(numbers.length) { false }

        dfs("", numbers, visited)

        for(num in duplication) {
            if(isPrime(num)) answer ++
        }

        return answer
    }

    fun dfs(num: String, numbers: String, visited: Array<Boolean>) {
        var str = num
        if(str == "0") return
        if(str.length >= numbers.length) return
        for(i in numbers.indices) {
            if(visited[i]) continue
            str += numbers[i]
            duplication.add(str.toInt())
            visited[i] = true
            dfs(str, numbers, visited)
            visited[i] = false
        }
    }

    fun isPrime(num: Int): Boolean {
        if(num == 2) return true
        for(i in 2 .. num) {
            if(i * i > num) return true
            if(num % i == 0) return false
        }
        return false
    }
}

fun main(){
    val a = 소수찾기()
    a.solution("123")
}