import kotlin.math.max

fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0

        for (s in input) {
            var valid = true
            val stringList = s.split(" ")
            val game = (stringList[1].slice(IntRange(0, stringList[1].length-2))).toInt()
            for (i in stringList.indices) {
                if (stringList[i].contains("red")) valid = stringList[i-1].toInt() <= 12
                if (stringList[i].contains("green")) valid = stringList[i-1].toInt() <= 13
                if (stringList[i].contains("blue")) valid = stringList[i-1].toInt() <= 14
                if (!valid) break
            }
            if (valid) sum += game
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0

        for (s in input) {
            var minRed = 0; var minGreen = 0; var minBlue = 0
            val stringList = s.split(" ")
            for (i in stringList.indices) {
                if (stringList[i].contains("red")) minRed = max(minRed, stringList[i-1].toInt())
                if (stringList[i].contains("green")) minGreen = max(minGreen, stringList[i-1].toInt())
                if (stringList[i].contains("blue")) minBlue = max(minBlue, stringList[i-1].toInt())
            }
            sum += minRed * minGreen * minBlue
        }
        return sum
    }
}
