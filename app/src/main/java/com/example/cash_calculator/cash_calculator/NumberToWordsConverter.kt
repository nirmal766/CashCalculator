package com.example.cash_calculator.cash_calculator
var zero:Long=0
var twenty:Long=20
var hundred:Long=100
var ten:Long=10
var thousand:Long=1000
var tenThousand:Long=10000
var lakh:Long=100000
var crore:Long=10000000
object NumberToWordsConverter {
    val units = arrayOf(
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
        "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
        "Eighteen", "Nineteen"
    )
    val tens = arrayOf(
        "",  // 0
        "",  // 1
        "Twenty",  // 2
        "Thirty",  // 3
        "Forty",  // 4
        "Fifty",  // 5
        "Sixty",  // 6
        "Seventy",  // 7
        "Eighty",  // 8
        "Ninety" // 9
    )

    fun convert(num : Long): String {
        var n=num
        if (n < zero) {
            return "Minus " + convert(-n).toLong()
        }
        if (n < twenty) {
            return units[n.toInt()]
        }
        if (n < hundred) {
            return tens[(n / ten).toInt()] + (if (n % ten != zero) " " else "") + units[(n % ten).toInt()]
        }
        if (n < thousand) {
            return units[(n / hundred).toInt()] + " Hundred" + (if (n % hundred != zero) " " else "") + convert(n % hundred)
        }
        if (n < lakh) {
            return convert(n / thousand) + " Thousand" + (if (n % tenThousand != zero) " " else "") + convert(n % thousand)
        }
        return if (n < crore) {
            convert(n / lakh) + " Lakh" + (if (n % lakh != zero) " " else "") + convert(n % lakh)
        } else convert(n / crore) + " Crore" + (if (n % crore != zero) " " else "") + convert(n % crore)
    }

    fun numToWords(n: Long): String { //optional
        val ntw = NumberToWordsConverter // directly implement this
        return convert(n.toLong())
    } //optional

}
