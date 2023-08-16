package programmers.레벨2

/*
문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

제한 조건
s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 */
class 레벨2_최댓값_최솟값 {
    fun solution(s: String): String {
        var answer = ""
        var max = Integer.MIN_VALUE
        var min = Integer.MAX_VALUE
        val arr = s.split(" ")

        for(i in arr){
            max = max.coerceAtLeast(i.toInt())
            min = min.coerceAtMost(i.toInt())
        }

        answer = "$min $max"

        return answer
    }

//    1이 너무 느려서 시도해봄 좀 더 빨라지긴 함
    fun 내풀이2(s: String): String {
        var answer = ""
        var integer = ""
        var max = Integer.MIN_VALUE
        var min = Integer.MAX_VALUE

        for(i in s.indices){
            if(s[i]==' '){
                max = max.coerceAtLeast(integer.toInt())
                min = min.coerceAtMost(integer.toInt())
                integer=""
            }else if (i==s.length-1){
                integer+=s[i]
                max = max.coerceAtLeast(integer.toInt())
                min = min.coerceAtMost(integer.toInt())
            }else{
                integer+=s[i]
            }
        }

        answer = "$min $max"

        return answer
    }
}