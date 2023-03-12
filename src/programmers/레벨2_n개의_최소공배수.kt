package programmers

import java.util.*

/*
두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

제한 사항
arr은 길이 1이상, 15이하인 배열입니다.
arr의 원소는 100 이하인 자연수입니다.
 */

//풀이 실패
class 레벨2_n개의_최소공배수 {
    fun 내풀이(arr: IntArray): Int {
        var answer = 0
        var temp = 1;

        Arrays.sort(arr)
        return answer
    }


//  answer을 1씩 올려가며 arr의 모든 수로 나눠지면 최소공배수
    fun 다른풀이1(arr: IntArray): Int {
        var answer = 1
        while (true) {
            var x = 0
            for (a in arr) x += answer % a
            if (x == 0) return answer
            answer++
        }
        return answer
    }

/** 최소공배수 문제는 이렇게 풀야아 함 */
//  유클리드 호제법을 이용한 풀이
    fun 다른풀이2(arr: IntArray): Int {
        var answer = arr[0]
        arr.forEach{ answer = lcm(answer, it) }
        return answer
    }

//  두수의 곱을 최대공약수로 나눈 값 = 최소공배수
    fun lcm(a:Int, b:Int) = a * b / gcd(a, b)

//  최대 공약수 구하기
    fun gcd(a:Int, b:Int):Int{
        return if (a < b){
            if (a == 0) b else gcd(a, b % a)
        }
        else{
            if (b == 0) a else gcd(b, a % b)
        }
    }
}