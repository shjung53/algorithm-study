package inflearn.second.dfs

/*
자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
예를 들어 5! = 5*4*3*2*1=120입니다.
 */
class 팩토리얼 {
    fun dfs(n: Int): Int {
        if (n == 1) {
            return 1
        } else {
            return n * dfs(n-1)
        }
    }
}