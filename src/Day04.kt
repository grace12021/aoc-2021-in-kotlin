import javax.lang.model.type.NullType
import kotlin.math.max
import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Int {
        val called_nums = input[0].split(",").map { it.toInt() }
        val length = input.size
        val nums = ((length-1)/6).toInt()

        var scoreboard: Array<IntArray> = Array(nums){IntArray(25)}
        for (i in 0..nums-1) {
            for (j in 0..4) {
                val line = input[i*6+j+2].split(" ").filter { it != "" }.map { it.toInt() }
                for (k in 0..4) {
                    scoreboard[i][j*5+k] = line[k]
                }
            }
        }

        var bingos: Array<IntArray> = Array(nums){ IntArray(10) }
        for (item in called_nums) {
            for (i in 0..nums-1) {
                val ind = scoreboard[i].indexOf(item)
                if (ind>-1) {
                    val x = ind/5
                    val y = ind%5
                    scoreboard[i][ind]=-1
                    bingos[i][x]+=1
                    bingos[i][5+y]+=1
                }
            }
            val isBingo = bingos.map { it.maxOrNull() }.indexOf(5)
            if (isBingo>-1) {
                val rest = scoreboard[isBingo].filter { it>0 }.sum()
                return rest*item
            }
        }
        return 0
    }

    fun part2(input: List<String>): Int {
        val called_nums = input[0].split(",").map { it.toInt() }
        val length = input.size
        val nums = ((length-1)/6).toInt()

        var scoreboard: Array<IntArray> = Array(nums){IntArray(25)}
        for (i in 0..nums-1) {
            for (j in 0..4) {
                val line = input[i*6+j+2].split(" ").filter { it != "" }.map { it.toInt() }
                for (k in 0..4) {
                    scoreboard[i][j*5+k] = line[k]
                }
            }
        }

        var bingos: Array<IntArray> = Array(nums){ IntArray(10) }
        var lastBoard = -1
        for (item in called_nums) {
            for (i in 0..nums-1) {
                val ind = scoreboard[i].indexOf(item)
                if (ind>-1) {
                    val x = ind/5
                    val y = ind%5
                    scoreboard[i][ind]=-1
                    bingos[i][x]+=1
                    bingos[i][5+y]+=1
                }
            }
            val isBingo = bingos.map {if (it.maxOrNull()==5) 0 else 1}
            if (isBingo.sum() == 1) {
                lastBoard = isBingo.indexOf(1)
            }
            if (isBingo.sum() == 0) {
                val rest = scoreboard[lastBoard].filter { it>0 }.sum()
                return rest*item
            }
        }
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 4512)
    check(part2(testInput) == 1924)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
