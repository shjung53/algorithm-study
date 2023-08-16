package inflearn.second.dfs

/*
자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요
 */
class 재귀함수 {
    fun dfs(n: Int) {
        if (n == 0) {
            return
        } else {
            dfs(n - 1)
            println(n)
        }
    }
}