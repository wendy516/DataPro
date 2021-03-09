package sort

/**
 * 冒泡排序
 * 升序排列
 */


fun bubbleSort(arr: IntArray) {
    var i = 0
    var j: Int
    while (i < arr.size) {
        j = arr.size - 1
        while (j > i) {
            if (arr[j] < arr[j - 1]) {
                var temp = arr[j]
                arr[j] = arr[j - 1]
                arr[j - 1] = temp
            }
            --j
        }
        ++i
    }
}

fun main() {

    var arr = intArrayOf(2, 3, 6, 5, 4, 1, 7, 9, 8)
    bubbleSort(arr)
    arr.forEach {
        println(it)
    }
}