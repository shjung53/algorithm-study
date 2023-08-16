package inflearn.second.dfs

class 중복순열 {

    lateinit var pm : Array<Int>

    fun solution(n: Int, m: Int){

        pm = Array<Int>(m){0}

        dfs(0, n, m)

    }

    fun dfs(idx: Int, n: Int, m: Int){
        if(idx==m) {
            for(num in pm){
                print(num)
            }
            println()
            return
        }



        for(i in 1 .. n){
            pm[idx] = i
            dfs(idx + 1, n, m)
        }
    }

}

fun main(){
    val a = 중복순열()
    a.solution(5,2)
}