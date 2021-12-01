fun main() {
    fun part1(input: List<String>): Int {
        val length = input.size

        var count = 0

        for (i in 0..length-2)
            if (input[i].toInt() < input[i+1].toInt()) count+=1

        return count
    }

    fun part2(input: List<String>): Int {
        val length = input.size

        var count = 0

        for (i in 0..length-4)
            if (input[i].toInt() < input[i+3].toInt()) count+=1

        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
