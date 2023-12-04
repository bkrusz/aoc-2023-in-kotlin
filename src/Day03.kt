fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        val flattenedInput = input.joinToString(separator = "")
        val numbers=("\\d+".toRegex().findAll(flattenedInput).toMutableList())
        val symbols=("[-\$%&*+=#@\\/]".toRegex().findAll(flattenedInput).toMutableList())
        for (number in numbers) {
            for (symbol in symbols) {
                if (number.range.contains(symbol.range.first - 1) || number.range.contains(symbol.range.first + 1) ||
                    number.range.contains(symbol.range.first - 141) || number.range.contains(symbol.range.first - 140) ||
                    number.range.contains(symbol.range.first - 139) || number.range.contains(symbol.range.first + 139) ||
                    number.range.contains(symbol.range.first + 140) || number.range.contains(symbol.range.first + 141)) {
                    sum += number.value.toInt()
                }
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var finalRatio = 0
        val flattenedInput = input.joinToString(separator = "")
        val numbers=("\\d+".toRegex().findAll(flattenedInput).toMutableList())
        val symbols=("[*]".toRegex().findAll(flattenedInput).toMutableList())
        for (symbol in symbols) {
            var ratio1 = 0
            var ratio2 = 0
            var isGear = false
            for (number in numbers) {
                if (number.range.contains(symbol.range.first - 1) || number.range.contains(symbol.range.first + 1) ||
                    number.range.contains(symbol.range.first - 141) || number.range.contains(symbol.range.first - 140) ||
                    number.range.contains(symbol.range.first - 139) || number.range.contains(symbol.range.first + 139) ||
                    number.range.contains(symbol.range.first + 140) || number.range.contains(symbol.range.first + 141)) {
                    if (ratio1 == 0) { ratio1 = number.value.toInt() }
                    else if (ratio2 == 0) { ratio2 = number.value.toInt(); isGear = true }
                    else { isGear = false }
                }
            }
            if (isGear) { finalRatio += ratio1 * ratio2 }
        }
        return finalRatio
    }
}
