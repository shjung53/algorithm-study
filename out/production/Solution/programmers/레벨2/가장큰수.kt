import java.util.*

/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 */

// compareTo에 대해서 더 알아보자
class Solution {
    fun 내풀이(numbers: IntArray): String {
        var answer = ""

        var numStr = Array<String>(numbers.size) { "" }

        for(i in numbers.indices) {
            numStr[i] = numbers[i].toString()
        }

        val c = Comparator() {
                o1: String, o2: String -> (o2 + o1).compareTo(o1 + o2)
        }

        Arrays.sort(numStr, c)

        for(str in numStr) {
            answer += str
        }

        if(answer[0] == '0') {
            answer = "0"
        }

        return answer
    }
}