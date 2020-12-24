class Condition(opt: Operator, opd: Int) {
    var operator: Operator = opt
    var operand: Int = opd

    override fun toString(): String {
        return "$operator $operand"
    }

    fun isSatisried(key: Int):Boolean{
        when(operator){
            Operator.GT -> return key>operand
            Operator.LT -> return key<operand
            Operator.GTE -> return key>=operand
            Operator.LTE -> return key<=operand
            Operator.NE -> return key!=operand
            Operator.EQ -> return key==operand
        }
    }
}