package array

/**
 * 如何找出数组中丢失的数
 * 给定一个未排序得数组，元素都是1到n不同得整数，找出缺失得整数
 * 方法1：累加求和法
 * 方法2：亦或法
 * 原理：异或性质：当两个数相同，为假，不同为真
 */

fun getNum(arr: IntArray): Int {

    if (arr.isEmpty()) {
        return -1
    }
    var a = arr[0]
    var b = 1
    val len = arr.size

    for (j in 1 until len) {
        a = a xor arr[j]
    }

    for (i in 2..len + 1) {
        b = b xor i
    }
    return a xor b
}


fun main() {
    val arr = intArrayOf(1, 4, 3, 2, 7, 5)
    println(getNum(arr))
}