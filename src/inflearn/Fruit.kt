package inflearn

open class Fruit: Bite{
    override fun bite(){
        println("과일")
    }
}
class Apple: Fruit(){
    override fun bite(){
        println("사과")
    }
}
class Banana: Fruit(){
    override fun bite(){
        println("바나나")
    }
}

interface Bite{
    fun bite(){
    }
}

fun varianceTest(coVar: Array<out Fruit>,contraVar: Array<in Apple>) {


    for(fruit in contraVar){
    }



}

fun main() {
    val fruits1 = Array<Apple>(3){_ -> Apple()}
    val fruits2 : Array<out Fruit>
    val fruits3 = Array<Fruit>(3){_ -> Fruit()}
    val fruits4 : Array<in Apple>
    val a = HashMap<>()

//  covariance
    fruits2 = fruits1

//  contravariance
    fruits4 = fruits3

    fruits2.get(0).bite()
    fruits4.get(0).bite()



    varianceTest(fruits2, fruits3) // ✅ working!
}