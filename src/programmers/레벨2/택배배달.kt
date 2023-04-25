package programmers.레벨2

class 택배배달 {

//    가까운 거리부터 한칸씩 이동하면서 배달하고 수거하기 - 틀린 답안
    fun 내풀이1(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0

        var leftDeliveries = deliveries.sum()
        var leftPickups = pickups.sum()

        val deliveriesD = IntArray(n + 1) { 0 }
        val pickupsD = IntArray(n + 1) { 0 }

        for(i in deliveries.indices) {
            deliveriesD[i + 1] = deliveries[i]
        }

        for(i in pickups.indices) {
            pickupsD[i + 1] = pickups[i]
        }

        var truckHas = 0

        while(leftDeliveries > 0 && leftPickups > 0) {

            var pos = 0

            if(leftDeliveries >= cap) {
                truckHas = cap
            } else {
                truckHas = leftDeliveries
            }

            while(truckHas > 0) {
                pos ++
                if(deliveriesD[pos] > 0) {
                    if(deliveriesD[pos] >= truckHas) {
                        deliveriesD[pos] -= truckHas
                        leftDeliveries -= truckHas
                        truckHas = 0
                    } else {
                        truckHas -= deliveriesD[pos]
                        leftDeliveries -= deliveriesD[pos]
                        deliveriesD[pos] = 0
                    }
                }
            }

            answer += pos * 2

            while(truckHas < cap) {
                if(pickupsD[pos] > 0) {
                    if(pickupsD[pos] <= cap - truckHas) {
                        truckHas += pickupsD[pos]
                        leftPickups -= pickupsD[pos]
                        pickupsD[pos] = 0
                    } else {
                        pickupsD[pos] -= (cap - truckHas)
                        leftPickups -= (cap - truckHas)
                        truckHas = cap
                    }
                }
                if(pos > 0) { pos -- } else {
                    break
                }
            }

            pos = 0
            truckHas = 0


        }

        return answer
    }
}