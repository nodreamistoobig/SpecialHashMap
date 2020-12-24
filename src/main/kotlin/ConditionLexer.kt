class ConditionLexer (val text:String) {
    private var pos: Int = 0
    private var currentChar: Char? = null
    val operators  = listOf('>','<','=')

    init {
        currentChar = text[pos]
    }

    fun nextCondition():Condition{

        lateinit var operator: Operator
        var operand = 0

        while (currentChar != null){
            if (currentChar!!.isWhitespace()){
                skip()
                continue
            }
            else if (currentChar!!.isDigit()){
                operand = number()
                skipDelimiter()
                val condition = Condition(operator, operand)
                return condition
            }
            else if (currentChar!! in operators){
                operator = comparision()
            }
            else
                break
        }

        throw InterpreterException("invalid operator")
    }

    private fun skipDelimiter() {
        if(currentChar!= null){
            while (!(currentChar!! in operators)){
                forward()
                if (currentChar==null || currentChar!!.isDigit())
                    throw InterpreterException("invalid operator")
            }
        }
    }

    private fun forward(){
        pos+=1
        if(pos>text.length - 1)
            currentChar = null
        else
            currentChar = text[pos]
    }

    private fun skip(){
        while((currentChar!=null) && currentChar!!.isWhitespace()){
            forward()
        }
    }

    private fun number(): Int {
        val result = arrayListOf<Char>()
        while((currentChar!=null) && (currentChar!!.isDigit())){
            result.add(currentChar!!)
            forward()
        }
        return result.joinToString("").toInt()
    }

    private fun comparision(): Operator {
        val result = arrayListOf<Char>()
        while((currentChar!=null) && (currentChar!! in operators)){
            result.add(currentChar!!)
            forward()
        }
        when (result.joinToString("")){
            ">" -> return Operator.GT
            "<" -> return Operator.LT
            ">=" -> return Operator.GTE
            "<=" -> return Operator.LTE
            "<>" -> return Operator.NE
            "=" -> return Operator.EQ
        }
        throw InterpreterException("invalid operator")
    }

    fun getConditions(): ArrayList<Condition> {
        val conditions = ArrayList<Condition>()
        while (currentChar != null){
            conditions.add(nextCondition())
        }
        return conditions
    }

}

class InterpreterException(message:String):Exception(message)
