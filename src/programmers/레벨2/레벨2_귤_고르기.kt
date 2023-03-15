package programmers.레벨2

/*
경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다. 그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화하고 싶습니다.

예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다. 경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.

경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다. 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.

제한사항
1 ≤ k ≤ tangerine의 길이 ≤ 100,000
1 ≤ tangerine의 원소 ≤ 10,000,000
 */

class 레벨2_귤_고르기 {
    fun 내풀이(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var count=0

//      index가 귤 사이즈, value가 귤의 갯수
        val countOfTangerine = IntArray(10000001){0}

//      index가 귤의 갯수, value가 귤 사이즈
        val order = Array<ArrayList<Int>>(100001){ArrayList<Int>()}

        for(tangerineSize in tangerine){
            countOfTangerine[tangerineSize]+=1
        }
        
        for(i in countOfTangerine.indices){
            if(countOfTangerine[i]>0){
                order[countOfTangerine[i]].add(i)
            }
        }

        for(j in order.size-1 downTo  1){
            if(order[j].size>0){
                for(l in order[j]){
                    if(count+j>=k){
                        answer++
                        return answer
                    }else{
                        answer++
                        count+=j
                    }
                }
            }
        }

        return answer
    }
}