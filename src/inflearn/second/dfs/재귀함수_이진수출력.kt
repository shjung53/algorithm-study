package inflearn.second.dfs

/*
10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단 재귀함수를 이용
해서 출력해야 합니다
 */
class 재귀함수_이진수출력 {

    fun dfs(n: Int) {
        if (n == 0) {
            return
        } else {
            dfs(n/2)
            print(n % 2)
        }
    }
}