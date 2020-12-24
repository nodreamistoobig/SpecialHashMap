fun main(){
    val test = SpecialHashMap<String, Int>()
    test["value1"] = 1
    test["value2"] = 2
    test["value3"] = 3
    test["1"] = 10
    test["2"] = 20
    test["3"] = 30
    test["1, 5"] = 100
    test["5, 5"] = 200
    test["10, 5"] = 300
    test["(1, 5, 3)"] = 400
    test["(5, 5, 4)"] = 500
    test["(10, 5, 5)"] = 600
    println("test.iloc(0) = ${test.iloc(0)}")
    println("test.iloc(2) = ${test.iloc(2)}")
    println("test.iloc(5) = ${test.iloc(5)}")
    println("test.iloc(8) = ${test.iloc(8)}")

    var c = ConditionLexer(">=10 >0")

    println(test.ploc(">=1"))
    println(test.ploc("<3"))

    println(test.ploc(">0 | >0"))
    println(test.ploc(">=10 $ >0"))

    println(test.ploc("<15 >=5% >=3"))
}



