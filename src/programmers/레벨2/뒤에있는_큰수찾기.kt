package programmers.레벨2

import java.util.*
/*
정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.

제한사항
4 ≤ numbers의 길이 ≤ 1,000,000
1 ≤ numbers[i] ≤ 1,000,000
 */
class 뒤에있는_큰수찾기 {

//    단순 2중포문이 시간이 초과돼서 뒤에서부터 스택을 쌓아 숫자를 찾아봤지만 특정 케이스 외엔 시간이 더 걸린다 ㅠ
    fun 내풀이(numbers: IntArray): IntArray {
        var answer = IntArray(numbers.size) { -1 }
        val stack = Stack<Int>()
        var max = 0

        for (i in numbers.lastIndex downTo 0) {
            val num = numbers[i]
            if (num >= max) {
                max = num
                stack.push(num)
                continue
            } else {
                if (stack.size > 0) answer[i] = findNum(stack, num)
                stack.push(num)
            }
        }

        return answer
    }

    fun findNum(stack: Stack<Int>, num: Int): Int {
        val newStack = stack.clone() as Stack<Int>
        while (num >= newStack.peek()){
            newStack.pop()

        }
        return newStack.peek()
    }
//    이전의 인덱스에서 해결이 되지 않으면 스택에 담아서 다음 인덱스에서 해결하는 방법
    fun 다른풀이(numbers: IntArray): IntArray {
        var answer = IntArray(numbers.size) { -1 }
        val stack = Stack<Int>()

        stack.push(0)

        for(i in 1 .. answer.lastIndex){
            while(!stack.isEmpty()){
                val idx = stack.pop()
                if(numbers[idx]<numbers[i]){
                    answer[idx]=numbers[i]
                }else{
                    stack.push(idx)
                    break
                }
            }
            stack.push(i)
        }

        return answer
    }

}

