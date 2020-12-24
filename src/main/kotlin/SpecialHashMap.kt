import java.util.*
import kotlin.collections.HashMap

class SpecialHashMap<T, U> : HashMap<String, Int>() {

}

fun SpecialHashMap<String, Int>.toSortedSet(): TreeMap<String, Int> {
    val sorted = TreeMap<String, Int>()
    sorted.putAll(this)
    return sorted
}

fun SpecialHashMap<String, Int>.iloc(n: Int): Int {
    val sorted = this.toSortedSet()
    var i: Int = 0
    for (elmt in sorted){
        if (i == n)
            return elmt.value
        else
            i++
    }
    return 0
}

fun SpecialHashMap<String, Int>.ploc(cnds: String): TreeMap<String, Int> {
    val sorted = this.toSortedSet()
    val result = TreeMap<String, Int>()
    val lexer = ConditionLexer(cnds)
    val conditions = lexer.getConditions()

    for (elmt in sorted){
        val keyLexer = KeyLexer(elmt)
        val keys = keyLexer.getKeysArray()
        if(keys.size == conditions.size){
            var it = 0
            var satisfied = true
            for(condition in conditions){
                if(!condition.isSatisried(keys[it])){
                    satisfied = false
                    break
                }
                it++
            }
            if (satisfied)
                result.put(keys.toString(),elmt.value)
        }

    }
    return result
}