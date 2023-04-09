package programmers.레벨2

class 오픈채팅방 {

    fun 내풀이(record: Array<String>): Array<String> {
        var temp = ArrayList<String>()

        val idMap = mutableMapOf<String, String>()

        for (i in record.indices) {
            val action = record[i].split(" ")[0]
            val uid: String = record[i].split(" ")[1]

            when (action) {
                "Enter" -> {
                    val nickname = record[i].split(" ")[2]
                    idMap[uid] = nickname
                    temp.add("${uid}님이 들어왔습니다.")
                }

                "Leave" -> {
                    temp.add("${uid}님이 나갔습니다.")
                }

                "Change" -> {
                    val nickname = record[i].split(" ")[2]
                    idMap[uid] = nickname
                }
            }
        }

        for (i in temp.indices) {
            temp[i] = idMap[temp[i].split("님")[0]] + temp[i].substring(temp[i].split("님")[0].length)

        }

        val answer = Array<String>(temp.size){""}

        for(i in temp.indices){
            answer[i] = temp[i]
        }


        return answer
    }


//    깔끔하다
    fun 다른풀이(record: Array<String>): Array<String> {
        val user = mutableMapOf<String, String>()

        return record
                .map {
                    val r = it.split(" ")
                    val action = r.first()
                    when (action) {
                        "Enter", "Change" -> user += r[1] to r[2]
                    }
                    r
                }
                .asSequence()
                .filter { it[0] != "Change" }
                .map {
                    val nickName = user[it[1]]
                    val explanation = when (it[0]) {
                        "Enter" -> "님이 들어왔습니다."
                        "Leave" -> "님이 나갔습니다."
                        else -> throw IllegalArgumentException()
                    }
                    "$nickName$explanation"
                }
                .toList().toTypedArray()
    }
}

