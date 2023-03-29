package programmers.레벨2

class JadenCase_문자열_만들기 {
    fun 내풀이(s: String): String {
        var answer = ""
        val str = s.lowercase()
        var pre =' '

        for(i in str.indices){
            answer += if(pre==' '){
                str[i].uppercase()
            }else{
                str[i]
            }
            pre=str[i]
        }

        return answer
    }

//    1보다 오래걸림 uppercaseChar가 boxing해서인것 같음 아직 모름
    fun 내풀이2(s: String): String {
        var answer = ""
        val str = s.lowercase()
        var pre =' '

        for(i in str.indices){
            answer += if(pre==' '){
                str[i].uppercaseChar()
            }else{
                str[i]
            }
            pre=str[i]
        }

        return answer
    }
}