package programmers.레벨1

/*
자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

제한사항
N의 범위 : 100,000,000 이하의 자연수
 */

class 레벨1_자릿수_더하기 {
    fun 내풀이(n: Int): Int {
        var answer = 0
        val str = n.toString()

        for(c in str){
            answer += Integer.parseInt(c.toString())
        }
        return answer
    }


//   이게 맞다! 10의 제곱수를 이용하긴 하려했는데 아랫자리부터 이용할 생각을 못했다..
    fun 다른풀이(n: Int): Int {
        var input = n
        var answer = 0

        while (input != 0) {
            answer += input % 10
            input /= 10
        }


        return answer
    }
}