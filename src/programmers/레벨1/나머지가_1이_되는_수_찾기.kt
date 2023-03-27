package programmers.레벨1

/*
문제 설명
자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 답이 항상 존재함은 증명될 수 있습니다.

제한사항
3 ≤ n ≤ 1,000,000
 */
class 나머지가_1이_되는_수_찾기 {
    fun 내풀이(n: Int): Int {
        var answer: Int = 0

        for(i in 2.. n){
            if(n % i==1){
                return i
            }
        }
        return answer
    }

//    깔끔한데 느림 Collection을 써서?
    fun 다른풀이(n: Int) = (1..n).first { n % it == 1 }
}