package euler.problem000.problem051_060

import euler.EulerExecutable
import euler.getInputLinesFromFile

class PokerHands: EulerExecutable {

    private val testInput = listOf(
            "5H 5C 6S 7S KD 2C 3S 8S 8D TD",
            "5D 8C 9S JS AC 2C 5C 7D 8S QH",
            "2D 9C AS AH AC 3D 6D 7D TD QD",
            "4D 6S 9H QH QC 3D 6D 7H QD QS",
            "2H 2D 4C 4D 4S 3C 3D 3S 9S 9D"
        )

    override fun solve(): Any {
        val input = getInputLinesFromFile("data/poker.txt")

        return input
            .map{it.split(" ")}
            .map{Pair(Player(it.take(5)), Player(it.takeLast(5)))}
            .map{Pair(it.first.pokerValue(), it.second.pokerValue())}
            .count { it.first > it.second }
    }
}

class Player(cardStringList: List<String>) {
    private val cardList = cardStringList.map{Card(it)}.sortedBy { it.value }
    private val groupedByValue = cardList.groupBy { it.value }

    override fun toString() = cardList.toString()

    fun pokerValue(): Long {
        val combiBasis = 10_000
        val combiValue = when {
            isRoyalFLush() -> 9*combiBasis
            isStraightFlush() -> 8*combiBasis
            isFourOfAKind() > 0 -> 7*combiBasis + isFourOfAKind()
            isFullHouse() > 0 -> 6*combiBasis + isFullHouse()
            isFlush() -> 5*combiBasis
            isStraight() -> 4*combiBasis
            isThreeOfAKind() > 0  -> 3*combiBasis + isThreeOfAKind()
            isTwoPairs() > 0  -> 2*combiBasis + isTwoPairs()
            isOnePair() > 0  -> 1*combiBasis + isOnePair()
            else -> 0
        }

        return 10_000_000L * combiValue + cardListValue()
    }

    private fun cardListValue(): Int {
        var sum = 0
        cardList.sortedBy { -it.value }.forEach {
            sum *= 15
            sum += it.value
        }
        return sum
    }

    private fun isOnePair(): Int {
        return if (groupedByValue.size == 4)
            groupedByValue.filter { it.value.size == 2 }.keys.first()
        else
            0
    }
    private fun isTwoPairs(): Int {
        return if (groupedByValue.size <= 3 && groupedByValue.values.maxOf { it.size } == 2)
                15*(groupedByValue.filter { it.value.size == 2 }.keys.maxOf { it }) + groupedByValue.filter { it.value.size == 2 }.keys.minOf { it }
            else
                0
    }
    private fun isThreeOfAKind(): Int {
        return groupedByValue.filter { it.value.size == 3 }.keys.firstOrNull() ?: 0
    }
    private fun isFullHouse(): Int {
        return if (groupedByValue.size == 2 && groupedByValue.values.maxOf { it.size } == 3)
            15*(groupedByValue.filter { it.value.size == 3 }.keys.first()) + groupedByValue.filter { it.value.size == 2 }.keys.first()
        else
            0
    }
    private fun isFourOfAKind(): Int {
        return groupedByValue.filter { it.value.size == 4 }.keys.firstOrNull() ?: 0
    }

    private fun isStraight() = cardList.filterIndexed { index, card -> cardList[0].value != card.value - index }.isEmpty()
    private fun isFlush() = cardList.all{it.suit == cardList[0].suit}
    private fun isStraightFlush() = isStraight() && isFlush()
    private fun isRoyalFLush() = isStraightFlush() && cardList[0].value == 10
}

class Card(card: String) {
    val suit: Char = card[1]
    val value: Int = when (card[0]) {
        'A' -> 14
        'K' -> 13
        'Q' -> 12
        'J' -> 11
        'T' -> 10
        else -> card[0] - '0'
    }

    override fun toString() = "$value$suit"
}