package programmers.레벨2

import com.sun.xml.internal.fastinfoset.util.StringArray

class 할인_행사 {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        val wants = LinkedHashSet<String>(10)
        val items = LinkedHashSet<String>(10)

        for(i in want.indices){
            for(j in 1 .. number[i]){
                wants.add(want[i])
            }
        }

        for(i in 0 .. discount.size-10){
            for(j in i .. i+9){
                items.add(discount[j])
            }
            if(wants.toSet()==items.toSet()){
                answer++
            }
            items.clear()
        }

        return answer
    }
}