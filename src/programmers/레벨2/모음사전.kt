package programmers.레벨2

/*
사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.

단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.

제한사항
word의 길이는 1 이상 5 이하입니다.
word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
 */
class Solution {
    val vowel = "AEIOU"
    var count = 0
    var answer = 0
    fun solution(word: String): Int {
        dfs(word, "")
        return answer
    }

    fun dfs(word: String, str: String) {
        if (str == word) answer = count
        count++
        if (str.length >= 5) {
            return
        }
        for (i in 0..vowel.length - 1) {
            dfs(word, str + vowel[i])
        }
    }
}

//    dfs하면서 list에 담아주고 idx로 순서를 찾는다. 빠르다 간결하고
val arr = arrayOf("A", "E", "I", "O", "U")
val result = mutableListOf<String>()

fun 다른풀이(word: String): Int {
    dfs("")
    result.forEachIndexed { idx, s ->
        if (s == word) return idx
    }
    return -1
}

fun dfs(str: String) {
    if (str.length > 5) return
    result.add(str)
    for (a in arr) {
        dfs(str + a)
    }
}