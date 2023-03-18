package programmers.레벨2

/*
정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.

n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ n ≤ 107
0 ≤ left ≤ right < n2
right - left < 105
 */

class `레벨2_n^2_배열_자르기` {
    fun 내풀이(n: Int, left: Long, right: Long): IntArray {
        var answer: IntArray = IntArray((right-left+1).toInt())

        for(index in left .. right){
//            2행부터는 반복되는 숫자가 생겨서 나머지+1해도 숫자를 특정할 수 없음
            if((index/n)-1>=0){
//                몫은 반복되는 숫자의 개수, 그 개수의 아래 인덱스들은 반복되는 숫자들
                if(index%n<(index/n)){
//                    몫+1이 반복되는 숫자
                    answer[(index-left).toInt()]= ((index/n+1)).toInt()
                    continue
                }else{
//                    반복되지 않는 숫자는 나머지+1 해주면 됨
                    answer[(index-left).toInt()]= ((index%n)+1).toInt()
                    continue
                }
            }
//            1행은 나머지 +1
            answer[(index-left).toInt()]= ((index%n)+1).toInt()
        }

        return answer
    }
}

fun main() {
    val a = `레벨2_n^2_배열_자르기`()
    a.내풀이(3,2,5)
}