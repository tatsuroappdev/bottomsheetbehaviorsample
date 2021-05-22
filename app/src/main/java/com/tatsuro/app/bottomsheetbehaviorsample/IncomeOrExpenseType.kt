package com.tatsuro.app.bottomsheetbehaviorsample

/** 収入または支出の種別 */
enum class IncomeOrExpenseType(private val strResId: Int) {

    SALARY(R.string.salary),
    PENSION(R.string.pension),
    REMITTANCE(R.string.remittance),
    POCKET_MONEY(R.string.pocket_money),
    BONUS(R.string.bonus),
    TEMPORARY_INCOME(R.string.temporary_income),
    LOAN(R.string.loan),
    INTEREST(R.string.interest),
    INVESTMENT_INCOME(R.string.investment_income),
    SALE_INCOME(R.string.sale_income);

    companion object {

        /**
         * 収入種別の配列を返す。
         * @return 収入種別の配列
         */
        fun incomeTypes(): Array<IncomeOrExpenseType> = arrayOf(
            SALARY,
            PENSION,
            REMITTANCE,
            POCKET_MONEY,
            BONUS,
            TEMPORARY_INCOME,
            LOAN,
            INTEREST,
            INVESTMENT_INCOME,
            SALE_INCOME
        )
    }

    override fun toString(): String {
        return App.getString(strResId)
    }
}