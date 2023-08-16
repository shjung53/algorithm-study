package inflearn.second.dfs

/*
자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램
을 작성하세요.
 */
class 부분집합 {
    lateinit var check: Array<Boolean>
    fun solution(n: Int) {
        check = Array<Boolean>(n + 1) { false }
        dfs(1, n)
    }

    fun dfs(idx: Int, n: Int){
        if(idx == n + 1){
            var list = ArrayList<Int>()
            for(i in 1 .. check.lastIndex){
                if(check[i]) list.add(i)
            }

            if(list.isEmpty()) return

            for(e in list){
                print(e.toString() + " ")
            }
            println()
            return
        }

        check[idx] = true
        dfs(idx + 1, n)
        check[idx] = false
        dfs(idx + 1, n)
    }
}