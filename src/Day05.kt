import javax.lang.model.type.NullType
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Int {
        val length = input.size
        var count = 0
        val list: MutableList<IntArray> = mutableListOf()
        var (xs, xe, ys, ye) = intArrayOf(10, -1, 10, -1)
        for (i in 0..length-1){
            val (p1, p2) = input[i].split(" -> ")
            val (x1, y1) = p1.split(",").map { it.toInt() }
            val (x2, y2) = p2.split(",").map { it.toInt() }
            xs = min(xs, min(x1, x2))
            ys = min(ys, min(y1, y2))
            xe = max(xe, max(x1, x2))
            ye = max(ye, max(y1, y2))
            if (x1 != x2 && y1 != y2) continue
            list.add(intArrayOf(x1, y1, x2, y2))
        }
        for (x in xs..xe) {
            for (y in ys..ye) {
                val eqs = list.map{
                    if (it[0]==it[2]) {
                        if (it[0]==x) {
                            if (it[1]<=y && y <=it[3]) 1
                            else if (it[3]<=y && y<=it[1]) 1
                            else 0
                        }
                        else 0
                    }
                    else if (min(it[0], it[2]) <= x && x <= max(it[0], it[2]) &&
                            min(it[1], it[3]) <= y && y <= max(it[1], it[3]) &&
                            (it[1]-it[3]).toFloat()/(it[0]-it[2]).toFloat()*(x-it[0])+it[1] == y.toFloat()) {
                        1
                    }
                    else {
                        0
                    }
                }
                if (eqs.sum()>1){
                    count+=1
                }
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        val length = input.size
        var count = 0
        val list: MutableList<IntArray> = mutableListOf()
        var (xs, xe, ys, ye) = intArrayOf(10, -1, 10, -1)
        for (i in 0..length-1){
            val (p1, p2) = input[i].split(" -> ")
            val (x1, y1) = p1.split(",").map { it.toInt() }
            val (x2, y2) = p2.split(",").map { it.toInt() }
            xs = min(xs, min(x1, x2))
            ys = min(ys, min(y1, y2))
            xe = max(xe, max(x1, x2))
            ye = max(ye, max(y1, y2))
            list.add(intArrayOf(x1, y1, x2, y2))
        }
        for (x in xs..xe) {
            for (y in ys..ye) {
                val eqs = list.map{
                    if (it[0]==it[2]) {
                        if (it[0]==x) {
                            if (it[1]<=y && y <=it[3]) 1
                            else if (it[3]<=y && y<=it[1]) 1
                            else 0
                        }
                        else 0
                    }
                    else if (min(it[0], it[2]) <= x && x <= max(it[0], it[2]) &&
                            min(it[1], it[3]) <= y && y <= max(it[1], it[3]) &&
                            (it[1]-it[3]).toFloat()/(it[0]-it[2]).toFloat()*(x-it[0])+it[1] == y.toFloat()) {
                        1
                    }
                    else {
                        0
                    }
                }
                if (eqs.sum()>1){
                    count+=1
                }
            }
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == 5)
    check(part2(testInput) == 12)

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
