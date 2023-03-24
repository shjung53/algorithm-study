package programmers.레벨2

class 레벨2_k진에서_소수_개수_구하기 {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        var nary = n.toString(k)

        while(nary.contains("00")){
            nary = nary.replace("00","0")
        }
        val arr = nary.split("0")

        for (s in arr) {
            if (s.isNotEmpty() && s.toInt() > 1) {
                if (checkPrimeNum(s.toInt())) {
                    answer++
                }
            }
        }



        return answer
    }

    private fun checkPrimeNum(num: Int): Boolean {
        for (i in 2 until num) {
            if(num and 1==0){
                return false
            }
            if (i * i >= num) {
                return true
            }
            if (num % i == 0) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val a = 레벨2_k진에서_소수_개수_구하기()
    a.solution(36, 3)
}