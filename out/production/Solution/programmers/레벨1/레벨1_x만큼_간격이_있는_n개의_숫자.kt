package programmers.레벨1

/*
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

제한 조건
x는 -10000000 이상, 10000000 이하인 정수입니다.
n은 1000 이하인 자연수입니다.
 */

class 레벨1_x만큼_간격이_있는_n개의_숫자 {
    fun 내풀이(x: Int, n: Int): LongArray {
        var answer = LongArray(n)

        for(i in 1 .. n){
            answer[i-1] = i*x.toLong()
        }

        return answer
    }

//    it은 현재 element가 생성되는 index를 가리킨다.
    fun 다른풀이(x: Int, n: Int): LongArray = LongArray(n) { x.toLong() * (it + 1) }
}