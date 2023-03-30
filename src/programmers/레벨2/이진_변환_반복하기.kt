package programmers.레벨2

class 이진_변환_반복하기 {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        var str = s
        var count1=0
        var count2=0

        while(str !="1"){
            val before = str.length
            str= str.replace("0","")
            val after = str.length
            count2+=before-after
            str=Integer.toBinaryString(after)
            count1++
        }

        answer = intArrayOf(count1,count2)

        return answer
    }
}