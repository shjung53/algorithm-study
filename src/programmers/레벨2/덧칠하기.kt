package programmers.레벨2

class 덧칠하기 {

//    첫풀이 조금 느려서 다른 코드도 짜봤다.
    fun 내풀이(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        val wall = IntArray(n+1){1}

        for(peeledWall in section){
            wall[peeledWall]=0
        }

        for(i in wall.indices){
            if(wall[i]<1){
                for(j in i until i+m){
                    if(j>wall.lastIndex){break}
                    wall[j]=1
                }
                answer++
            }
        }

        return answer
    }

//    1번보다도 느림 while과 contains 때문인 것 같다.
    fun 내풀이2(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        var paintingPos =0

        while(paintingPos<=n){
            if(section.contains(paintingPos)){
                paintingPos+=m
                answer++
            }else{
                paintingPos++
            }
        }

        return answer
    }

//    제일 빠르고 차이가 꽤 난다.
    fun 내풀이3(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        var paintedPos =0

        for(peeledWall in section){
            if(peeledWall>paintedPos){
                paintedPos=peeledWall+m-1
                answer++
            }
        }

        return answer
    }
}