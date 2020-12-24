import java.util.*

class KeyLexer(elmt: MutableMap.MutableEntry<String, Int>) {
    var keys = ArrayList<Int>()
    var elmt: MutableMap.MutableEntry<String, Int>
    init {
        this.elmt = elmt
    }

    fun getKeysArray(): ArrayList<Int> {
        var isNmb = true
        val availableChar = listOf<Char>('(', ')', ',', '0','1','2','3','4','5','6','7','8','9')
        for (c in elmt.key){
            if (!(c in availableChar) && !c.isWhitespace()){
                isNmb = false
                break
            }
        }
        if (isNmb){
            val key_str = elmt.key.split(",")
            for (k in key_str){
                var number: Int = k.replace(" ", "").replace("(", "").replace(")", "").toInt()
                keys.add(number)
            }
        }
        return keys
    }
}