fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        for (string in input) {
            val allDigits = string.mapIndexedNotNull { _, c: Char -> if (c.isDigit()) c else null }
            sum += ((allDigits.first().code - 48) * 10) + (allDigits.last().code - 48)
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val numStrings = mapOf("zero" to 0, "one" to 1, "two" to 2, "three" to 3, "four" to 4,
            "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9)

        var sum = 0
        for (string in input) {
            val firstNumWord = string.findAnyOf(numStrings.keys, ignoreCase = true)
            val lastNumWord = string.findLastAnyOf(numStrings.keys, ignoreCase = true)
            val firstNumber = string.findAnyOf(numStrings.values.map { it.toString() })
            val lastNumber = string.findLastAnyOf(numStrings.values.map { it.toString() })

            val tens: Int = if (firstNumWord != null && firstNumber == null) {
                numStrings[firstNumWord.second]!!
            } else if (firstNumWord == null && firstNumber != null) {
                firstNumber.second.toInt()
            } else {
                if (firstNumWord!!.first < firstNumber!!.first) numStrings[firstNumWord.second]!! else firstNumber.second.toInt()
            }

            val ones: Int = if (lastNumWord != null && lastNumber == null) {
                numStrings[lastNumWord.second]!!
            } else if (lastNumWord == null && lastNumber != null) {
                lastNumber.second.toInt()
            } else {
                if (lastNumWord!!.first > lastNumber!!.first) numStrings[lastNumWord.second]!! else lastNumber.second.toInt()
            }

            sum += tens*10 + ones
        }
        return sum
    }
}
