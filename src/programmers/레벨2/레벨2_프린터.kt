package programmers.레벨2

import java.util.*

class 레벨2_프린터 {
    fun 내풀이(priorities: IntArray, location: Int): Int {
        var answer = 0
        val queue = LinkedList<Script>()

        for (order in priorities.indices) {
            if (order == location) {
                queue.offer(Script("target", priorities[order]))
            } else {
                queue.offer(Script(order.toString(), priorities[order]))
            }
        }

        while (checkTarget(queue,"target",priorities[location])) {
            var goBack = false
            val temp: Script = queue.pop()

            for (script in queue) {
                if (temp.priority < script.priority) {
                    queue.offer(temp)
                    goBack = true
                    break
                }
            }

            if (goBack) {
                continue
            } else {
                answer++
            }
        }




        return answer
    }

    private fun checkTarget(queue: LinkedList<Script>, name: String, priority: Int): Boolean{
        for(script in queue){
            if(script.name==name){
                return true
            }
        }
        return false
    }
}

fun main(){
    val a  = 레벨2_프린터()
    a.내풀이(intArrayOf(2,1,3,2),2)
}

class Script(val name: String, val priority: Int)