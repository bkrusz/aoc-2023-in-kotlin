fun main() {
    fun part1(input: List<String>): Int {
        var total = 1
        val time = "\\d+".toRegex().findAll(input[0]).groupBy { it.value.toInt() }.keys
        val distance = "\\d+".toRegex().findAll(input[1]).groupBy { it.value.toInt() }.keys
        for (t in time.indices) {
            var numTimesBeat = 0
            for (i in 1..<time.elementAt(t)) {
                if (i * (time.elementAt(t) - i) > distance.elementAt(t)) {
                    numTimesBeat += 1
                }
            }
            total *= numTimesBeat
        }
        return total
    }

    fun part2(input: List<String>): Int {
        var total = 1
        val time = "\\d+".toRegex().findAll(input[0]).groupBy { it.value.toInt() }.keys.joinToString("").toLong()
        val distance = "\\d+".toRegex().findAll(input[1]).groupBy { it.value }.keys.joinToString("").toLong()
        var numTimesBeat = 0
        for (i in 1..<time) {
            if (i * (time - i) > distance) {
                numTimesBeat += 1
            }
        }
        total *= numTimesBeat
        return total
    }
}
