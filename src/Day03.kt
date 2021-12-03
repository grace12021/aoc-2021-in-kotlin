import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Int {
        val num = input.size
        val length = input[0].length

        var gamma = 0
        var epsilon = 0

        for (i in 0..length-1) {
            val occurance_1 = input.count { it[length-1-i]=='1' }
            val addition = 2.toDouble().pow(i).toInt()
            if (occurance_1 > num/2) {
                gamma+=addition
            } else {
                epsilon+=addition
            }
        }
        return gamma*epsilon
    }

    fun part2(input: List<String>): Int {
        val num = input.size
        val length = input[0].length

        var o2 = 0
        var co2 = 0
        var prefixmost = ""
        var prefixleast = ""

        for (i in 0..length-1) {
            val total_most = input.count { it.startsWith(prefixmost) }
            val total_least = input.count { it.startsWith(prefixleast) }
            val occurance_most = input.count { it.startsWith(prefixmost) && it[i]=='1' }
            val occurance_least = input.count { it.startsWith(prefixleast) && it[i]=='1' }
            val addition = 2.toDouble().pow(length-1-i).toInt()
            if (occurance_most*2 >= total_most) {
                prefixmost+=1.toString()
                o2+=addition
            }
            else {
                prefixmost+=0.toString()
            }
            if (total_least < 2) {
                if (occurance_least == 1) {
                    prefixleast+=1.toString()
                    co2+=addition
                }
                else {
                    prefixleast+=0.toString()
                }
            }
            else {
                if (occurance_least*2 < total_least) {
                    prefixleast+=1.toString()
                    co2+=addition
                }
                else {
                    prefixleast+=0.toString()
                }
            }
        }
        return o2*co2
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
