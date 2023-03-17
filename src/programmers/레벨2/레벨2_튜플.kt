package programmers.레벨2
/*
셀수있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플(tuple)이라고 합니다. n개의 요소를 가진 튜플을 n-튜플(n-tuple)이라고 하며, 다음과 같이 표현할 수 있습니다.

(a1, a2, a3, ..., an)
튜플은 다음과 같은 성질을 가지고 있습니다.

중복된 원소가 있을 수 있습니다. ex : (2, 3, 1, 2)
원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플입니다. ex : (1, 2, 3) ≠ (1, 3, 2)
튜플의 원소 개수는 유한합니다.
원소의 개수가 n개이고, 중복되는 원소가 없는 튜플 (a1, a2, a3, ..., an)이 주어질 때(단, a1, a2, ..., an은 자연수), 이는 다음과 같이 집합 기호 '{', '}'를 이용해 표현할 수 있습니다.

{{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}
예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는

{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
와 같이 표현할 수 있습니다. 이때, 집합은 원소의 순서가 바뀌어도 상관없으므로

{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
{{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
{{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.

특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.

[제한사항]
s의 길이는 5 이상 1,000,000 이하입니다.
s는 숫자와 '{', '}', ',' 로만 이루어져 있습니다.
숫자가 0으로 시작하는 경우는 없습니다.
s는 항상 중복되는 원소가 없는 튜플을 올바르게 표현하고 있습니다.
s가 표현하는 튜플의 원소는 1 이상 100,000 이하인 자연수입니다.
return 하는 배열의 길이가 1 이상 500 이하인 경우만 입력으로 주어집니다.
 */

/**
 * HashMap과 IntArray를 사용해서 풀어봤다. 결과는 IntArray가 속도와 공간 면에서 더 우월했다.
 * Hash를 사용할만큼 키가 Sparse하려면 키의 정의역이 무한해야할 것 같다. 혹은 더 크거나?
 */
class 레벨2_튜플 {

//  HashMap 사용
    fun 내풀이(s: String): IntArray {
        var answer = ArrayList<Int>()
        var copyS = s
        val arr1 = IntArray(100001)
        val arr2 = IntArray(1000001)

        copyS=s.replace("{","")
        copyS=copyS.replace("}", "")

        val temp: List<String> = copyS.split(",")

        for (str in temp) {
            val i = Integer.valueOf(str)
            arr1[i] +=1
        }

        for(j in arr1.indices){
            if(arr1[j]>0){
                arr2[arr1[j]]= j
            }
        }

        for(k in arr2.size-1 downTo 0){
            if(arr2[k]>0){
                answer.add(arr2[k])
            }
        }



        return answer.toIntArray()
    }

//  IntArray 사용
    fun 내풀이2(s: String): IntArray {
        var answer = ArrayList<Int>()
        val map = HashMap<Int, Int>()
        var copyS = s

        copyS=s.replace("{","")
        copyS=copyS.replace("}", "")

        val temp: List<String> = copyS.split(",")

        for (str in temp) {
            val i = Integer.valueOf(str)
            map[i] = map.getOrDefault(i, 0) + 1
        }

        while(answer.size<map.keys.size){
            var max: Int = 0
            for (key in map.keys) {
                if(map[key]!!>map.getOrDefault(max,0)){
                    max = key
                }
            }
            answer.add(max)
            map[max] = 0
        }


        return answer.toIntArray()
    }

}

fun main(){
    레벨2_튜플().내풀이("{{2},{2,1},{2,1,3},{2,1,3,4}}")
}

