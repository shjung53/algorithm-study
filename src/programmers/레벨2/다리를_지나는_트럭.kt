package programmers.레벨2

import java.util.*

class 다리를_지나는_트럭 {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        answer += bridge_length

        val onBridge = LinkedList<Truck>()

        var onBridgeWeight = 0

        onBridge.offer(Truck(truck_weights[0],0))
        onBridgeWeight += truck_weights[0]
        answer++

        for(i in truck_weights.indices){
            while(onBridgeWeight+truck_weights[i]>weight){
                for(truck in onBridge){
                    truck.addTime()
                }
            }

            answer++
            onBridge.offer(Truck(truck_weights[i],1))
        }


        return answer
    }

    class Truck(public var weight: Int, var time: Int){
        fun addTime(){
            this.time++
        }
    }
}