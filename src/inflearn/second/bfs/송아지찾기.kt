package inflearn.second.bfs

import java.util.*

/*
현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다. 현수의 위치와 송아
지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음
과 같은 방법으로 이동한다. 송아지는 움직이지 않고 제자리에 있다.
현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수
있다. 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성
하세요.
▣ 입력설명
첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000
까지이다.
▣ 출력설명
점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.
 */
class 송아지찾기 {
    fun solution(s: Int, e: Int) {
        var count = 0

        val step = LinkedList<Int>()

        step.offer(s)

        outer@
        while (step.isNotEmpty()) {
            for(i in 0 until step.size) {
                val nowPos = step.poll()
                if(nowPos == e) {
                    print(count)
                    break@outer
                } else {
                    if(nowPos + 1 in 1..10000) step.offer(nowPos + 1)
                    if(nowPos + 5 in 1..10000) step.offer(nowPos + 5)
                    if(nowPos - 1 in 1..10000) step.offer(nowPos - 1)
                }
            }
            count++
        }
    }
}