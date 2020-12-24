import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class SpecialHashMapKtTest{
    @Test
    fun check_iloc1(){
        val test = SpecialHashMap<String, Int>()
        test.put("87", 20)
        test.put("value7", 51)
        test.put("1,4", 22)
        test.put("(3,89)", 123)
        test.put("0", 90)
        assertEquals(51, test.iloc(4))
    }

    @Test
    fun check_iloc2(){
        val test = SpecialHashMap<String, Int>()
        test.put("-76", 1)
        test.put("hfjb", 2)
        test.put("[91,94,98]", 3)
        test.put("(3,89)", 4)
        test.put("{0}", 5)
        assertEquals(4, test.iloc(0))
    }

    @Test
    fun check_ploc1(){
        val test = SpecialHashMap<String, Int>()
        test.put("87", 20)
        test.put("value7", 51)
        test.put("1,4", 22)
        test.put("(3,    89)", 123)
        test.put("0", 90)

        var result = TreeMap<String, Int>()
        result.put("[3, 89]", 123)

        assertEquals(result, test.ploc(">2 | <100"))
    }

    @Test
    fun check_ploc2(){
        val test = SpecialHashMap<String, Int>()
        test.put("-76", 1)
        test.put("hfjb", 2)
        test.put("[91,94,98]", 3)
        test.put("(3,89)", 4)
        test.put("{0}", 5)
        test.put("(12,   98,  732,     0)", 6)
        test.put("(12,   98,  742,     0)", 7)

        var result = TreeMap<String, Int>()
        result.put("[12, 98, 732, 0]", 6)

        assertEquals(result, test.ploc(">10 | =98 | <742 | <=0"))
    }


}