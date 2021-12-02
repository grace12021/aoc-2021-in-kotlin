fun main() {
    fun part1(input: List<String>): Int {
        val length = input.size

        var width = 0
        var depth = 0

        for (i in 0..length-1) {
            val command = input[i].split(" ")
            when (command[0]) {
                "forward" -> width+=command[1].toInt()
                "up" -> depth-=command[1].toInt()
                "down" -> depth+=command[1].toInt()
            }
        }

        return width*depth
    }

    fun part2(input: List<String>): Int {
        val length = input.size

        var width = 0
        var depth = 0
        var aim = 0

        for (i in 0..length-1) {
            val command = input[i].split(" ")
            val num = command[1].toInt()
            when (command[0]) {
                "forward" -> {
                    width+=num
                    depth+=(aim*num)
                }
                "up" -> {
                    aim-=num
                }
                "down" -> {
                    aim+=num
                }
            }
        }

        return width*depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
