package programmers.레벨2

/* 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.

제한 조건
행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
곱할 수 있는 배열만 주어집니다. */

/** 큰 행렬의 곱셈인 경우 Strassen 알고리즘을 사용하면 시간복잡도를 O(n^3)에서 O(N^log2(7)) ≈ O(N^2.81)로 단축할 수 있다.
 * 하지만 연산이 많으므로 작은 행렬간의 곱셈은 일반적인 방법이 빠를 수 있다.
 */

class 레벨2_행렬의_곱셈 {
    fun 내풀이(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = Array<IntArray>(arr1.size){IntArray(arr2[0].size)}


        for(i in arr1.indices){
            for(j in 0 until arr2[0].size){
                var value = 0
                for(k in 0 until arr1[i].size){
                    value += arr1[i][k] * arr2[k][j]
                }

                answer[i][j] = value
            }
        }



        return answer
    }
}
