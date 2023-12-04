import kotlin.math.pow

fun main() {
    fun matches(card: String): Int {
        val matches = "\\d+".toRegex().findAll(card.split(": ")[1]).groupBy { it.value.toInt() }
        return (matches.filter { it.value.size == 2}).size
    }

    fun cardScore(card: String): Int {
        return 2.0.pow((matches(card))/2.0).toInt()
    }

    fun part1(input: List<String>): Int {
        var scoreTotal = 0
        for (card in input) {
            scoreTotal += cardScore(card)
        }
        return scoreTotal
    }

    fun part2(input: List<String>): Int {
        val cardCounts = mutableListOf<Int>()
        for (i in input.indices) {
            cardCounts.add(1)
        }
        for (card in input.indices) {
            var startingCard = card + 1
            val endCard = matches(input[card]) + startingCard - 1
            while (startingCard <= endCard && startingCard < cardCounts.size) {
                cardCounts[startingCard] += cardCounts[card]
                startingCard += 1
            }
        }
        return cardCounts.sum()
    }
}
